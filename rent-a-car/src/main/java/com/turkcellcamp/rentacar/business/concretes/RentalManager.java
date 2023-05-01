package com.turkcellcamp.rentacar.business.concretes;

import com.turkcellcamp.rentacar.business.abstracts.CarService;
import com.turkcellcamp.rentacar.business.abstracts.InvoiceService;
import com.turkcellcamp.rentacar.business.abstracts.PaymentService;
import com.turkcellcamp.rentacar.business.abstracts.RentalService;
import com.turkcellcamp.rentacar.business.dto.requests.create.CreateInvoiceRequest;
import com.turkcellcamp.rentacar.business.dto.requests.create.CreateRentalRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdateRentalRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateRentalResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllRentalsResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetCarResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetRentalResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdateRentalResponse;
import com.turkcellcamp.rentacar.business.rules.RentalManagerRule;
import com.turkcellcamp.rentacar.common.dto.CreateRentalPaymentRequest;
import com.turkcellcamp.rentacar.entities.Rental;
import com.turkcellcamp.rentacar.entities.enums.State;
import com.turkcellcamp.rentacar.repository.RentalRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private final RentalRepository repository;
    private final ModelMapper mapper;
    private final CarService carService;
    private final PaymentService paymentService;
    private final InvoiceService invoiceService;
    private final RentalManagerRule rentalManagerRule;

    @Override
    public List<GetAllRentalsResponse> getAll() {
        List<Rental> rentals = repository.findAll();
        List<GetAllRentalsResponse> response = rentals
                .stream()
                .map(rental -> mapper.map(rental, GetAllRentalsResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetRentalResponse getById(int id) {
        rentalManagerRule.checkIfRentalExists(id);

        Rental rental = repository.findById(id).orElseThrow();
        GetRentalResponse response = mapper.map(rental, GetRentalResponse.class);

        return response;
    }

    @Override
    public CreateRentalResponse add(CreateRentalRequest request) {
        rentalManagerRule.checkIfCarAvailable(carService.getById(request.getCarId()).getState());

        Rental rental = mapper.map(request, Rental.class);
        rental.setId(0);
        rental.setTotalPrice(getTotalPrice(rental));
        rental.setStartDate(LocalDateTime.now());

        CreateRentalPaymentRequest paymentRequest = new CreateRentalPaymentRequest();
        mapper.map(request.getPaymentRequest(), paymentRequest);
        paymentRequest.setPrice(getTotalPrice(rental));
        paymentService.processRentalPayment(paymentRequest);

        repository.save(rental);
        carService.changeState(request.getCarId(), State.RENTED);
        CreateRentalResponse response = mapper.map(rental, CreateRentalResponse.class);

        CreateInvoiceRequest invoiceRequest = new CreateInvoiceRequest();
        createInvoiceRequest(request, invoiceRequest);
        invoiceService.add(invoiceRequest);

        return response;
    }

    @Override
    public UpdateRentalResponse update(int id, UpdateRentalRequest request) {
        rentalManagerRule.checkIfRentalExists(id);

        Rental rental = mapper.map(request, Rental.class);
        rental.setId(id);
        rental.setTotalPrice(getTotalPrice(rental));
        repository.save(rental);

        UpdateRentalResponse response = mapper.map(rental, UpdateRentalResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        rentalManagerRule.checkIfRentalExists(id);

        int carId = repository.findById(id).get().getCar().getId();
        carService.changeState(carId, State.AVAILABLE);
        repository.deleteById(id);
    }

    private double getTotalPrice(Rental rental) {
        return rental.getDailyPrice() * rental.getRentedForDays();
    }

    private void createInvoiceRequest(CreateRentalRequest rentalRequest, CreateInvoiceRequest invoiceRequest){
        GetCarResponse carResponse = carService.getById(rentalRequest.getCarId());

        invoiceRequest.setBrandName(carResponse.getModelBrandName());
        invoiceRequest.setModelName(carResponse.getModelName());
        invoiceRequest.setModelYear(carResponse.getModelYear());
        invoiceRequest.setPlate(carResponse.getPlate());
        invoiceRequest.setDailyPrice(rentalRequest.getDailyPrice());
        invoiceRequest.setCardHolder(rentalRequest.getPaymentRequest().getCardHolder());
        invoiceRequest.setRentedForDays(rentalRequest.getRentedForDays());
    }
}
