package com.turkcell.ecommerce.api.controllers;

import com.turkcell.ecommerce.api.request.InvoiceRequest;
import com.turkcell.ecommerce.api.response.InvoiceResponse;
import com.turkcell.ecommerce.service.InvoiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/invoices")
public class InvoicesController {
    private final InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<List<InvoiceResponse>> getAll() {
        return ResponseEntity.ok(invoiceService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceResponse> getById(@PathVariable int id){
        return ResponseEntity.ok(invoiceService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceResponse> update(@PathVariable int id, @Valid @RequestBody InvoiceRequest request){
        return ResponseEntity.ok(invoiceService.updateById(id, request));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        invoiceService.deleteById(id);
    }
}
