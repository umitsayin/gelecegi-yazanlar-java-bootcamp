package com.turkcellcamp.rentacar.api.controllers;

import com.turkcellcamp.rentacar.business.abstracts.CarService;
import com.turkcellcamp.rentacar.business.dto.requests.create.CreateCarRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdateCarRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateCarResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllCarsResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetCarResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdateCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor

public class CarsController {
    private final CarService carService;

    @GetMapping
    public List<GetAllCarsResponse> getAll(@RequestParam(defaultValue = "true") boolean includeMaintenance) {
        return carService.getAll(includeMaintenance);
    }

    @GetMapping("/{id}")
    public GetCarResponse getById(@PathVariable int id) {
        return carService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCarResponse add(@Valid @RequestBody CreateCarRequest request) {
        return carService.add(request);
    }

    @PutMapping("/{id}")
    public UpdateCarResponse update(@PathVariable int id, @RequestBody UpdateCarRequest request) {
        return carService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        carService.delete(id);
    }
}

