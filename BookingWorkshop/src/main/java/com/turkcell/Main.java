package com.turkcell;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        CorporateCustomer corporateCustomer1 = new CorporateCustomer(1, "kodlamaio","545454554");
        IndividualCustomer individualCustomer1 = new IndividualCustomer(2, "Ümit", "Sayın", "2323232323");
        IndividualCustomer individualCustomer2 = new IndividualCustomer();
        individualCustomer2.setId(3);
        individualCustomer2.setFirstName("Burak");
        individualCustomer2.setLastName("Yapıcı");
        individualCustomer2.setNationalityId("323232323");

        Hotel hotel = new Hotel(1, "Hilton");

        Booking booking1 = new Booking();
        booking1.setId(1);
        booking1.setStartDate(new Date());
        booking1.setEndDate(new Date());
        booking1.setDailyPrice(3000);
        booking1.setCustomer(individualCustomer1);
        booking1.setHotel(hotel);

        Booking booking2 = new Booking();
        booking2.setId(1);
        booking2.setStartDate(new Date());
        booking2.setEndDate(new Date());
        booking2.setDailyPrice(2222);
        booking2.setCustomer(individualCustomer2);
        booking2.setHotel(hotel);

        Booking booking3 = new Booking();
        booking3.setId(1);
        booking3.setStartDate(new Date());
        booking3.setEndDate(new Date());
        booking3.setDailyPrice(2222);
        booking3.setCustomer(corporateCustomer1);
        booking3.setHotel(hotel);

        System.out.println(booking1.toString());
        System.out.println(booking2.toString());
        System.out.println(booking3.toString());
    }
}