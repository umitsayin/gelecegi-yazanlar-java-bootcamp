package com.turkcell.inmemoryecommerceworkshop.business.concretes;

import com.turkcell.inmemoryecommerceworkshop.business.abstracts.ProductService;
import com.turkcell.inmemoryecommerceworkshop.entities.Product;
import com.turkcell.inmemoryecommerceworkshop.repository.abstracts.ProductRepository;
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
        return productRepository.getAll();
    }

    @Override
    public Product getById(int id) {
        return productRepository.getById(id);
    }

    @Override
    public Product add(Product product) {
        validateProduct(product);
        return productRepository.add(product);
    }

    @Override
    public Product update(int id, Product product) {
        validateProduct(product);
        return productRepository.update(id, product);
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
