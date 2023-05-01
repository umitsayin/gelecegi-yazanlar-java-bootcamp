package com.turkcell;

public class CustomerManager {

    private final Verification verification;

    public CustomerManager(Verification verification) {
        this.verification = verification;
    }

    public void add(Customer customer) {
        if (verification.checkIfReal(customer)) {
            System.out.println("Kullanıcı doğrulandı");
        } else {
            System.out.println("Kullanıcı doğrulanamadı");
        }
    }
}
