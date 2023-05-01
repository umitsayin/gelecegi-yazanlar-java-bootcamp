package com.turkcellcamp.rentacar.business.rules;

import com.turkcellcamp.rentacar.common.constants.Messages;
import com.turkcellcamp.rentacar.core.exceptions.BusinessException;
import com.turkcellcamp.rentacar.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelManagerRules {
    private final ModelRepository repository;

    public void checkIfModelExistsById(int id){
        if(!repository.existsById(id)){
            throw new BusinessException(Messages.Model.MODEL_NOT_FOUND);
        }
    }

    public void checkIfModelExistsByName(String name){
        if (repository.existsByNameIgnoreCase(name)) {
            throw new BusinessException(Messages.Model.MODEL_ALREADY_EXISTS);
        }
    }
}
