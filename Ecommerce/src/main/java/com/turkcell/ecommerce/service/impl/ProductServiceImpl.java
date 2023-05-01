package com.turkcell.ecommerce.service.impl;

import com.turkcell.ecommerce.api.request.ProductRequest;
import com.turkcell.ecommerce.api.response.CategoryResponse;
import com.turkcell.ecommerce.api.response.ProductResponse;
import com.turkcell.ecommerce.entities.Category;
import com.turkcell.ecommerce.entities.Product;
import com.turkcell.ecommerce.repository.ProductRepository;
import com.turkcell.ecommerce.service.CategoryService;
import com.turkcell.ecommerce.service.ProductService;
import com.turkcell.ecommerce.service.rules.ProductServiceRules;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final ProductRepository repository;
    private final ProductServiceRules rules;

    @Override
    public List<ProductResponse> getAll() {
        List<ProductResponse> response = repository.findAll().stream()
                .map(product -> modelMapper.map(product, ProductResponse.class))
                .toList();

        return response;
    }

    @Override
    public ProductResponse getById(int id) {
        rules.checkIfProductExistsByID(id);

        ProductResponse response = modelMapper.map(repository.findById(id), ProductResponse.class);

        return response;
    }

    @Override
    public ProductResponse add(ProductRequest request) {
        rules.checkIfProductExistsByName(request.getName());

        Product product = modelMapper.map(request, Product.class);
        product.setId(0);
        setCategoryToProduct(request.getCategoryIds(), product);
        repository.save(product);

        ProductResponse response = modelMapper.map(product, ProductResponse.class);

        return response;
    }

    @Override
    public ProductResponse updateById(int id, ProductRequest request) {
        rules.checkIfProductExistsByID(id);

        Product product = modelMapper.map(request, Product.class);
        product.setId(id);
        setCategoryToProduct(request.getCategoryIds(), product);
        repository.save(product);

        ProductResponse response = modelMapper.map(product, ProductResponse.class);

        return response;
    }

    @Override
    public void deleteById(int id) {
        rules.checkIfProductExistsByID(id);
        repository.deleteById(id);
    }

    private void setCategoryToProduct(List<Integer> categoryIds, Product product){
        categoryIds.stream().forEach(categoryId-> {
            product.getCategories().add(modelMapper.map(categoryService.getById(categoryId), Category.class));
        });
    }
}
