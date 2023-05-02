package com.turkcell.ecommerce.service.rules;

import com.turkcell.ecommerce.constant.ExceptionConstant;
import com.turkcell.ecommerce.exception.BusinessException;
import com.turkcell.ecommerce.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleServiceRules {
    private final SaleRepository repository;

    public void checkIfSaleExistsById(int id){
        if(!repository.existsById(id)){
            throw new BusinessException(ExceptionConstant.SALE_NOT_FOUND);
        }
    }
}
