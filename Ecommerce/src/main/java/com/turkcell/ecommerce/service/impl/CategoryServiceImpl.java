package com.turkcell.ecommerce.service.impl;

import com.turkcell.ecommerce.api.request.CategoryRequest;
import com.turkcell.ecommerce.api.response.CategoryResponse;
import com.turkcell.ecommerce.entities.Category;
import com.turkcell.ecommerce.repository.CategoryRepository;
import com.turkcell.ecommerce.service.CategoryService;
import com.turkcell.ecommerce.service.rules.CategoryServiceRules;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final ModelMapper modelMapper;
    private final CategoryRepository repository;
    private final CategoryServiceRules rules;

    @Override
    public List<CategoryResponse> getAll() {
        List<CategoryResponse> response = repository.findAll().stream()
                .map(category -> modelMapper.map(category, CategoryResponse.class))
                .toList();

        return response;
    }

    @Override
    public CategoryResponse getById(int id) {
        rules.checkIfCategoryExistsById(id);

        CategoryResponse response = modelMapper.map(repository.findById(id), CategoryResponse.class);

        return response;
    }

    @Override
    public CategoryResponse add(CategoryRequest request) {
        rules.checkIfCategoryExistsByName(request.getName());

        Category category = modelMapper.map(request, Category.class);
        category.setId(0);
        repository.save(category);

        CategoryResponse response = modelMapper.map(category, CategoryResponse.class);

        return response;
    }

    @Override
    public CategoryResponse updateById(int id, CategoryRequest request) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
