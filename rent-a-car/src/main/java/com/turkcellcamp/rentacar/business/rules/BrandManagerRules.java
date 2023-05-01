package com.turkcellcamp.rentacar.business.rules;

import com.turkcellcamp.rentacar.common.constants.Messages;
import com.turkcellcamp.rentacar.core.exceptions.EntityAlreadyExistsException;
import com.turkcellcamp.rentacar.core.exceptions.EntityNotFoundException;
import com.turkcellcamp.rentacar.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandManagerRules {
    private final BrandRepository repository;

    public void checkIfBrandExists(int id) {
        if (!repository.existsById(id))
            throw new EntityNotFoundException(Messages.Brand.BRAND_NOT_FOUND);
    }

    public void checkIfBrandExistsByName(String name){
        if(repository.existsBrandByNameIgnoreCase(name)){
            throw new EntityAlreadyExistsException(Messages.Brand.BRAND_ALREADY_EXISTS);
        }
    }
}
