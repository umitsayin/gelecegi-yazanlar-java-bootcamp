package com.turkcell.ecommerce.service;

import com.turkcell.ecommerce.api.request.ProductRequest;
import com.turkcell.ecommerce.api.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAll();
    ProductResponse getById(int id);
    ProductResponse add(ProductRequest request);
    ProductResponse updateById(int id, ProductRequest request);
    void deleteById(int id);
}
