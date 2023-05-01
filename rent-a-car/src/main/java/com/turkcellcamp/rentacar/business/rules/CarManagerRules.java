package com.turkcellcamp.rentacar.business.rules;

import com.turkcellcamp.rentacar.common.constants.Messages;
import com.turkcellcamp.rentacar.core.exceptions.BusinessException;
import com.turkcellcamp.rentacar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarManagerRules {
    private final CarRepository repository;

    public void checkIfCarExists(int id) {

        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Car.CAR_NOT_FOUND);
        }
    }

    public void checkIfCarExistsByPlate(String plate) {
        if (repository.existsByPlate(plate)) {
            throw new BusinessException(Messages.Car.PLATE_EXISTS);
        }
    }
}
