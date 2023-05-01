package com.turkcellcamp.rentacar.business.concretes;

import com.turkcellcamp.rentacar.business.abstracts.InvoiceService;
import com.turkcellcamp.rentacar.business.dto.requests.create.CreateInvoiceRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdateInvoiceRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateInvoiceResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllInvoicesResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetInvoiceResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdateInvoiceResponse;
import com.turkcellcamp.rentacar.business.rules.InvoiceManagerRules;
import com.turkcellcamp.rentacar.entities.Invoice;
import com.turkcellcamp.rentacar.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceManager implements InvoiceService {
    private final InvoiceRepository repository;
    private final ModelMapper modelMapper;
    private final InvoiceManagerRules rules;

    @Override
    public List<GetAllInvoicesResponse> getAll() {
        List<Invoice> invoices = repository.findAll();
        List<GetAllInvoicesResponse> response = invoices.stream()
                .map(invoice -> modelMapper.map(invoice, GetAllInvoicesResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetInvoiceResponse getById(int id) {
        rules.checkIfInvoiceExistsById(id);

        Invoice invoice = repository.findById(id).get();
        GetInvoiceResponse response = modelMapper.map(invoice,GetInvoiceResponse.class);

        return response;
    }

    @Override
    public CreateInvoiceResponse add(CreateInvoiceRequest request) {
        Invoice invoice = modelMapper.map(request, Invoice.class);
        invoice.setId(0);
        invoice.setTotalPrice(getTotalPrice(invoice));
        repository.save(invoice);

        CreateInvoiceResponse response = modelMapper.map(invoice, CreateInvoiceResponse.class);

        return response;
    }

    @Override
    public UpdateInvoiceResponse update(int id, UpdateInvoiceRequest request) {
        rules.checkIfInvoiceExistsById(id);

        Invoice invoice = modelMapper.map(request, Invoice.class);
        invoice.setId(id);
        invoice.setTotalPrice(getTotalPrice(invoice));
        repository.save(invoice);

        UpdateInvoiceResponse response = modelMapper.map(invoice, UpdateInvoiceResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfInvoiceExistsById(id);

        repository.deleteById(id);
    }

    private double getTotalPrice(Invoice invoice) {
        return invoice.getDailyPrice() * invoice.getRentedForDays();
    }
}
