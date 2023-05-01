package com.turkcell.ecommerce.api.controllers;

import com.turkcell.ecommerce.api.request.ProductRequest;
import com.turkcell.ecommerce.api.response.ProductResponse;
import com.turkcell.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductsController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable int id){
        return ResponseEntity.ok(productService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> add(@Valid @RequestBody ProductRequest request){
        return ResponseEntity.ok(productService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateById(@PathVariable int id, @RequestBody ProductRequest request){
        return ResponseEntity.ok(productService.updateById(id,request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id){
        productService.deleteById(id);
    }
}
