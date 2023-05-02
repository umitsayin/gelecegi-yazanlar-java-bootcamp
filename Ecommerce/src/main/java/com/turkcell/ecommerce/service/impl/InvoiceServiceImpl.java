package com.turkcell.ecommerce.service.impl;

import com.turkcell.ecommerce.api.request.InvoiceRequest;
import com.turkcell.ecommerce.api.response.InvoiceResponse;
import com.turkcell.ecommerce.entities.Invoice;
import com.turkcell.ecommerce.repository.InvoiceRepository;
import com.turkcell.ecommerce.service.InvoiceService;
import com.turkcell.ecommerce.service.rules.InvoiceServiceRules;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final ModelMapper modelMapper;
    private final InvoiceRepository repository;
    private final InvoiceServiceRules rules;

    @Override
    public List<InvoiceResponse> getAll() {
        List<InvoiceResponse> response = repository.findAll().stream()
                .map(invoice -> modelMapper.map(invoice, InvoiceResponse.class))
                .toList();

        return response;
    }

    @Override
    public InvoiceResponse getById(int id) {
        rules.checkIfInvoiceExistsById(id);

        InvoiceResponse response = modelMapper.map(repository.findById(id), InvoiceResponse.class);

        return response;
    }

    @Override
    public InvoiceResponse add(InvoiceRequest request) {
        Invoice invoice = modelMapper.map(request, Invoice.class);
        invoice.setId(0);
        repository.save(invoice);

        InvoiceResponse response = modelMapper.map(invoice, InvoiceResponse.class);

        return response;
    }

    @Override
    public InvoiceResponse updateById(int id, InvoiceRequest request) {
        rules.checkIfInvoiceExistsById(id);

        Invoice invoice = modelMapper.map(request, Invoice.class);
        invoice.setId(id);
        repository.save(invoice);

        InvoiceResponse response = modelMapper.map(invoice, InvoiceResponse.class);

        return response;
    }

    @Override
    public void deleteById(int id) {
        rules.checkIfInvoiceExistsById(id);

        repository.deleteById(id);
    }
}
