package com.turkcellcamp.rentacar.business.abstracts;

import com.turkcellcamp.rentacar.business.dto.requests.create.CreateInvoiceRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdateInvoiceRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateInvoiceResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllInvoicesResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetInvoiceResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdateInvoiceResponse;

import java.util.List;

public interface InvoiceService {
    List<GetAllInvoicesResponse> getAll();
    GetInvoiceResponse getById(int id);
    CreateInvoiceResponse add(CreateInvoiceRequest request);
    UpdateInvoiceResponse update(int id, UpdateInvoiceRequest request);
    void delete(int id);
}
