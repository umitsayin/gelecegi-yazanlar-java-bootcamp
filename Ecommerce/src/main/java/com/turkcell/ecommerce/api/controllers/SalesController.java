package com.turkcell.ecommerce.api.controllers;

import com.turkcell.ecommerce.api.request.SaleRequest;
import com.turkcell.ecommerce.api.response.SaleResponse;
import com.turkcell.ecommerce.service.SaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sales")
public class SalesController {
    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<List<SaleResponse>> getAll(){
        return ResponseEntity.ok(saleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleResponse> getById(int id){
        return ResponseEntity.ok(saleService.getById(id));
    }

    @PostMapping
    public ResponseEntity<SaleResponse> add(@Valid @RequestBody SaleRequest request){
        return ResponseEntity.ok(saleService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleResponse> update(@PathVariable int id, @Valid @RequestBody SaleRequest request){
        return ResponseEntity.ok(saleService.updateById(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        saleService.deleteById(id);
    }
}
