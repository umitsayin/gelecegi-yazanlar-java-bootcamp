package com.turkcell.ecommerce.api.controllers;

import com.turkcell.ecommerce.api.request.CategoryRequest;
import com.turkcell.ecommerce.api.response.CategoryResponse;
import com.turkcell.ecommerce.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoriesController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAll(){
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable int id){
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> add(@Valid @RequestBody CategoryRequest request){
        return ResponseEntity.ok(categoryService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateById(@PathVariable int id, @RequestBody CategoryRequest request){
        return ResponseEntity.ok(categoryService.updateById(id,request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id){
        categoryService.deleteById(id);
    }
}
