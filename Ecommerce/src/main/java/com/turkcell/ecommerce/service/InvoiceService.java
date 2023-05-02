package com.turkcell.ecommerce.service;

import com.turkcell.ecommerce.api.request.InvoiceRequest;
import com.turkcell.ecommerce.api.response.InvoiceResponse;

import java.util.List;

public interface InvoiceService {
    List<InvoiceResponse> getAll();
    InvoiceResponse getById(int id);
    InvoiceResponse add(InvoiceRequest request);
    InvoiceResponse updateById(int id, InvoiceRequest request);
    void deleteById(int id);
}
