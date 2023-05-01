package com.turkcellcamp.rentacar.business.abstracts;

import com.turkcellcamp.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllMaintenancesResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetMaintenanceResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;

import java.util.List;

public interface MaintenanceService {
    List<GetAllMaintenancesResponse> getAll();
    GetMaintenanceResponse getById(int id);
    GetMaintenanceResponse returnCarFromMaintenance(int carId);
    CreateMaintenanceResponse add(CreateMaintenanceRequest request);
    UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request);
    void delete(int id);
}
