package com.turkcell.inmemoryecommerceworkshop.repository.concretes;

import com.turkcell.inmemoryecommerceworkshop.entities.Product;
import com.turkcell.inmemoryecommerceworkshop.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private List<Product> products;

    public InMemoryProductRepository() {
        this.products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 10, 20000, "laptop description"));
        products.add(new Product(2, "Phone", 5, 15000, "phone description"));
        products.add(new Product(3, "Keyboard", 20, 1000, "keyboard description"));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        return products.get(id-1);
    }

    @Override
    public Product add(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product update(int id, Product product) {
        return products.set(id-1, product);
    }

    @Override
    public void deleteById(int id) {
        products.remove(id-1);
    }
}
