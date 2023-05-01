package com.turkcell.ecommerce.service;

import com.turkcell.ecommerce.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product getById(int id);

    Product add(Product product);

    Product update(int id, Product product);

    void deleteById(int id);
}
