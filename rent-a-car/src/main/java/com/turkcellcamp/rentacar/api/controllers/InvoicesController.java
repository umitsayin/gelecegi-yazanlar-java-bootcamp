package com.turkcellcamp.rentacar.api.controllers;

import com.turkcellcamp.rentacar.business.abstracts.InvoiceService;
import com.turkcellcamp.rentacar.business.dto.requests.create.CreateInvoiceRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdateInvoiceRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateInvoiceResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllInvoicesResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetInvoiceResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdateInvoiceResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@RequiredArgsConstructor
public class InvoicesController {
    private final InvoiceService invoiceService;

    @GetMapping
    public List<GetAllInvoicesResponse> getAll(){
        return invoiceService.getAll();
    }

    @GetMapping("/{id}")
    public GetInvoiceResponse getById(@PathVariable int id){
        return invoiceService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateInvoiceResponse add(@Valid @RequestBody CreateInvoiceRequest request){
        return invoiceService.add(request);
    }

    @PutMapping("/{id}")
    public UpdateInvoiceResponse update(@PathVariable int id, @Valid @RequestBody UpdateInvoiceRequest request){
        return invoiceService.update(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        invoiceService.delete(id);
    }
}
