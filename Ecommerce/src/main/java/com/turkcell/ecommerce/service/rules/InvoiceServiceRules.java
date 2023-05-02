package com.turkcell.ecommerce.service.rules;

import com.turkcell.ecommerce.constant.ExceptionConstant;
import com.turkcell.ecommerce.exception.BusinessException;
import com.turkcell.ecommerce.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceServiceRules {
    private final InvoiceRepository repository;

    public void checkIfInvoiceExistsById(int id){
        if(!repository.existsById(id)){
            throw new BusinessException(ExceptionConstant.INVOICE_NOT_FOUND);
        }
    }
}
