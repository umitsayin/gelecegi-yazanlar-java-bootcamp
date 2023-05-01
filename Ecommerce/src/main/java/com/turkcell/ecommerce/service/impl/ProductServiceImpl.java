package com.turkcell.ecommerce.service.impl;

import com.turkcell.ecommerce.entities.Product;
import com.turkcell.ecommerce.repository.ProductRepository;
import com.turkcell.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        return productRepository.getById(id);
    }

    @Override
    public Product add(Product product) {
        validateProduct(product);

        return productRepository.save(product);
    }

    @Override
    public Product update(int id, Product product) {
        validateProduct(product);
        return productRepository.save(product);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    private void validateProduct(Product product) {
        checkIfUnitPriceValid(product);
        checkIfQuantityValid(product);
        checkIfDescriptionValid(product);
    }

    private void checkIfUnitPriceValid(Product product) {
        if (product.getUnitPrice() <= 0) {
            throw new IllegalArgumentException("Price cannot be less than or equal to 0");
        }
    }

    private void checkIfQuantityValid(Product product) {
        if (product.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity cannot be less than 0");
        }
    }

    private void checkIfDescriptionValid(Product product) {
        if (product.getDescription().length() < 10 || product.getDescription().length() > 50 ) {
            throw new IllegalArgumentException("Description length must be between 10 and 50 characters");
        }
    }
}
