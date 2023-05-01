package com.turkcell.ecommerce.service;

import com.turkcell.ecommerce.api.request.CategoryRequest;
import com.turkcell.ecommerce.api.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAll();
    CategoryResponse getById(int id);
    CategoryResponse add(CategoryRequest request);
    CategoryResponse updateById(int id, CategoryRequest request);
    void deleteById(int id);
}
