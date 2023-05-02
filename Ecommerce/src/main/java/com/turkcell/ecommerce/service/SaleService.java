package com.turkcell.ecommerce.service;

import com.turkcell.ecommerce.api.request.SaleRequest;
import com.turkcell.ecommerce.api.response.SaleResponse;

import java.util.List;

public interface SaleService {
    List<SaleResponse> getAll();
    SaleResponse getById(int id);
    SaleResponse add(SaleRequest request);
    SaleResponse updateById(int id, SaleRequest request);
    void deleteById(int id);
}
