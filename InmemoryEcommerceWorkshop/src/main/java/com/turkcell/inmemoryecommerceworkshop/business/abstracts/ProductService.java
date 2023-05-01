package com.turkcell.inmemoryecommerceworkshop.business.abstracts;

import com.turkcell.inmemoryecommerceworkshop.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product getById(int id);

    Product add(Product product);

    Product update(int id, Product product);

    void deleteById(int id);
}
