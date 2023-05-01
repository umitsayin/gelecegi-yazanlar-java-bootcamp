package com.turkcell;

public class EDevletVerificationAdapter implements Verification{

    private final EDevletService eDevletService = new EDevletService();

    @Override
    public boolean checkIfReal(Customer customer) {
        return eDevletService.verify(
                customer.getFirstName(),
                customer.getLastName(),
                customer.getBirthYear(),
                customer.getNationalityID()
        );
    }
}
