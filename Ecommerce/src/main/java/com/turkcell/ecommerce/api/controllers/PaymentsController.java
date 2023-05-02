package com.turkcell.ecommerce.api.controllers;

import com.turkcell.ecommerce.api.request.PaymentRequest;
import com.turkcell.ecommerce.api.response.PaymentResponse;
import com.turkcell.ecommerce.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentsController {
    private final PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<PaymentResponse>> getAll(){
        return ResponseEntity.ok(paymentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getById(@PathVariable int id){
        return ResponseEntity.ok(paymentService.getById(id));
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> add(@Valid @RequestBody PaymentRequest request){
        return ResponseEntity.ok(paymentService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentResponse> update(@PathVariable int id, @Valid @RequestBody PaymentRequest request){
        return ResponseEntity.ok(paymentService.updateByID(id,request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        paymentService.deleteById(id);
    }
}
