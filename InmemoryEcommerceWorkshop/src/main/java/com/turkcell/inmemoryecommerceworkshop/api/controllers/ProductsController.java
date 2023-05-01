package com.turkcell.inmemoryecommerceworkshop.api.controllers;

import com.turkcell.inmemoryecommerceworkshop.business.abstracts.ProductService;
import com.turkcell.inmemoryecommerceworkshop.entities.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return productService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product add(@RequestBody Product product) {
        return productService.add(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id) {
        productService.deleteById(id);
    }
}
