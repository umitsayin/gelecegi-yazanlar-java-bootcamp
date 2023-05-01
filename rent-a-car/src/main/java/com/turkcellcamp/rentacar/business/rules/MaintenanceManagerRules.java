package com.turkcellcamp.rentacar.business.rules;

import com.turkcellcamp.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import com.turkcellcamp.rentacar.common.constants.Messages;
import com.turkcellcamp.rentacar.core.exceptions.BusinessException;
import com.turkcellcamp.rentacar.entities.enums.State;
import com.turkcellcamp.rentacar.repository.MaintenanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MaintenanceManagerRules {
    private final MaintenanceRepository repository;

    public void checkIfMaintenanceExists(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Maintenance.MAINTENANCE_NOT_FOUND);
        }
    }

    public void checkIfCarIsNotUnderMaintenance(int carId) {
        if (!repository.existsByCarIdAndIsCompletedIsFalse(carId)) {
            throw new BusinessException(Messages.Car.CAR_NOT_FOUND);
        }
    }

    public void checkIfCarUnderMaintenance(int carId) {
        if (repository.existsByCarIdAndIsCompletedIsFalse(carId)) {
            throw new BusinessException(Messages.Maintenance.CAR_UNDER_THE_MAINTENANCE);
        }
    }

    public void checkCarAvailabilityForMaintenance(State state) {
        if (state.equals(State.RENTED)) {
            throw new BusinessException(Messages.Car.CAR_IS_NOT_AVAILABLE);
        }
    }
}
