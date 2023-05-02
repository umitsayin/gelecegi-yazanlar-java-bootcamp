package com.turkcell.ecommerce.service.impl;

import com.turkcell.ecommerce.api.request.InvoiceRequest;
import com.turkcell.ecommerce.api.request.SaleRequest;
import com.turkcell.ecommerce.api.response.SaleResponse;
import com.turkcell.ecommerce.entities.Invoice;
import com.turkcell.ecommerce.entities.Product;
import com.turkcell.ecommerce.entities.Sale;
import com.turkcell.ecommerce.repository.SaleRepository;
import com.turkcell.ecommerce.service.InvoiceService;
import com.turkcell.ecommerce.service.PaymentService;
import com.turkcell.ecommerce.service.ProductService;
import com.turkcell.ecommerce.service.SaleService;
import com.turkcell.ecommerce.service.rules.SaleServiceRules;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {
    private final ModelMapper modelMapper;
    private final PaymentService paymentService;
    private final InvoiceService invoiceService;
    private final ProductService productService;
    private final SaleRepository repository;
    private final SaleServiceRules rules;

    @Override
    public List<SaleResponse> getAll() {
        List<SaleResponse> response = repository.findAll().stream()
                .map(sale -> modelMapper.map(sale, SaleResponse.class))
                .toList();


        return response;
    }

    @Override
    public SaleResponse getById(int id) {
        rules.checkIfSaleExistsById(id);

        SaleResponse response = modelMapper.map(repository.findById(id),SaleResponse.class);

        return response;
    }

    @Override
    public SaleResponse add(SaleRequest request) {
        Sale sale = modelMapper.map(request, Sale.class);
        sale.setId(0);
        setSaleProductsByIds(request.getProductIds(), sale);

        paymentService.processSalePayment(request.getPayment());

        InvoiceRequest invoiceRequest = new InvoiceRequest();
        getInvoiceRequest(sale, invoiceRequest);

        Invoice invoice = modelMapper.map(invoiceService.add(invoiceRequest), Invoice.class);
        sale.setInvoice(invoice);
        repository.save(sale);

        SaleResponse response = modelMapper.map(sale, SaleResponse.class);

        return response;
    }

    @Override
    public SaleResponse updateById(int id, SaleRequest request) {
        rules.checkIfSaleExistsById(id);

        return null;
    }

    @Override
    public void deleteById(int id) {
        rules.checkIfSaleExistsById(id);

        repository.deleteById(id);
    }

    private void setSaleProductsByIds(List<Integer> productIds, Sale sale){
        productIds.stream().forEach(id -> {
                sale.getProducts().add(modelMapper.map(productService.getById(id), Product.class));
        });
    }

    private void getInvoiceRequest(Sale sale, InvoiceRequest request){
        request.setDescription(sale.getDescription());
        request.setName(sale.getDescription());
        request.setTotalPrice(sale.getTotalPrice());
    }
}
