package com.turkcell.ecommerce.service.rules;

import com.turkcell.ecommerce.constant.ExceptionConstant;
import com.turkcell.ecommerce.exception.BusinessException;
import com.turkcell.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceRules {
    private final ProductRepository repository;

    public void checkIfProductExistsByID(int id){
        if(!repository.existsById(id)){
            throw new BusinessException(ExceptionConstant.PRODUCT_NOT_FOUND);
        }
    }

    public void checkIfProductExistsByName(String name){
        if(repository.existsByName(name)){
            throw new BusinessException(ExceptionConstant.PRODUCT_ALREADY_EXISTS);
        }
    }
}
