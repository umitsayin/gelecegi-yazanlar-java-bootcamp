package com.turkcellcamp.rentacar.business.concretes;

import com.turkcellcamp.rentacar.business.abstracts.CarService;
import com.turkcellcamp.rentacar.business.abstracts.MaintenanceService;
import com.turkcellcamp.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetCarResponse;
import com.turkcellcamp.rentacar.business.rules.MaintenanceManagerRules;
import com.turkcellcamp.rentacar.entities.Car;
import com.turkcellcamp.rentacar.entities.Maintenance;
import com.turkcellcamp.rentacar.entities.enums.State;
import com.turkcellcamp.rentacar.repository.MaintenanceRepository;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceManagerTest {
    private CarService carService;
    private ModelMapper modelMapper;
    private MaintenanceManagerRules rules;
    private MaintenanceRepository repository;
    private MaintenanceService maintenanceService;

    @BeforeEach
    void setUp(){
        carService = mock(CarService.class);
        modelMapper = mock(ModelMapper.class);
        rules = mock(MaintenanceManagerRules.class);
        repository = mock(MaintenanceRepository.class);
        maintenanceService = new MaintenanceManager(repository, modelMapper, carService, rules);
    }


    @Test
    void testAdd_WithCreateMaintenanceRequest_thenReturnCreateMaintenanceResponse(){
        CreateMaintenanceRequest request = new CreateMaintenanceRequest();
        request.setCarId(1);
        request.setInformation("Genel bakım");
        State state = State.AVAILABLE;

        Maintenance maintenance = new Maintenance();
        maintenance.setInformation(request.getInformation());
        maintenance.setId(0);
        maintenance.setCompleted(false);
        maintenance.setStartDate(LocalDateTime.now());
        maintenance.setEndDate(null);


        GetCarResponse carResponse = new GetCarResponse();
        carResponse.setState(state);

        when(carService.getById(request.getCarId())).thenReturn(carResponse);
        doNothing().when(rules).checkIfCarUnderMaintenance(request.getCarId());
        doNothing().when(rules).checkCarAvailabilityForMaintenance(state);
        when(modelMapper.map(request, Maintenance.class)).thenReturn(maintenance);
        when(repository.save(maintenance)).thenReturn(maintenance);
        doNothing().when(carService).changeState(request.getCarId(),State.MAINTENANCE);


        CreateMaintenanceResponse expected = new CreateMaintenanceResponse();
        expected.setId(0);
        expected.setCarId(1);
        expected.setInformation(request.getInformation());
        expected.setCompleted(maintenance.isCompleted());
        expected.setStartDate(maintenance.getStartDate());
        expected.setEndDate(maintenance.getEndDate());

        when(modelMapper.map(maintenance,CreateMaintenanceResponse.class)).thenReturn(expected);

        CreateMaintenanceResponse result = maintenanceService.add(request);

        assertEquals(expected.toString(), result.toString());
    }
}