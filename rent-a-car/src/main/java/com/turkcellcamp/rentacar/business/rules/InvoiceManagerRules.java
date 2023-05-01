package com.turkcellcamp.rentacar.business.rules;

import com.turkcellcamp.rentacar.common.constants.Messages;
import com.turkcellcamp.rentacar.core.exceptions.BusinessException;
import com.turkcellcamp.rentacar.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceManagerRules {
    private final InvoiceRepository repository;

    public void checkIfInvoiceExistsById(int id){
        if(!repository.existsById(id)){
            throw new BusinessException(Messages.Invoice.INVOICE_NOT_FOUND);
        }
    }
}
