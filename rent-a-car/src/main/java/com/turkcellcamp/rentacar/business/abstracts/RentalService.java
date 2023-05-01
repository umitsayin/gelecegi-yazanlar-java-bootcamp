package com.turkcellcamp.rentacar.business.abstracts;

import com.turkcellcamp.rentacar.business.dto.requests.create.CreateRentalRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdateRentalRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateRentalResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllRentalsResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetRentalResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdateRentalResponse;

import java.util.List;

public interface RentalService {
    List<GetAllRentalsResponse> getAll();
    GetRentalResponse getById(int id);
    CreateRentalResponse add(CreateRentalRequest request);
    UpdateRentalResponse update(int id, UpdateRentalRequest request);
    void delete(int id);
}
