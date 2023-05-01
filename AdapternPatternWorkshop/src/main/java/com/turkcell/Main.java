package com.turkcell;

public class Main {

    public static void main(String[] args) {

        CustomerManager customerManager = new CustomerManager(new EDevletVerificationAdapter());
        Customer customer1 = new Customer("Ümit", "Sayın", 1998, "11111111111");
        Customer customer2 = new Customer("Ümit", "Sayın", 1999, "11231231233");

        customerManager.add(customer1);
        customerManager.add(customer2);
    }
}
