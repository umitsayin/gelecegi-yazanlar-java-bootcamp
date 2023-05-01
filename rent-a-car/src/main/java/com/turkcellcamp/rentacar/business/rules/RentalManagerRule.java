package com.turkcellcamp.rentacar.business.rules;

import com.turkcellcamp.rentacar.common.constants.Messages;
import com.turkcellcamp.rentacar.core.exceptions.BusinessException;
import com.turkcellcamp.rentacar.entities.enums.State;
import com.turkcellcamp.rentacar.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RentalManagerRule {
    private final RentalRepository repository;

    public void checkIfRentalExists(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Rental.RENTAL_NOT_FOUND);
        }
    }

    public void checkIfCarAvailable(State state) {
        if (!State.AVAILABLE.equals(state)) {
            throw new BusinessException(Messages.Car.CAR_IS_NOT_AVAILABLE);
        }
    }
}
