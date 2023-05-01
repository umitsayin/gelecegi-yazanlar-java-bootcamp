package com.turkcell;

public class Main {
    public static void main(String[] args) {
        RestaurantOrder restaurantOrder = new RestaurantOrder(1, "Yağız", 232, false, true);
        restaurantOrder.orderToPay();
        restaurantOrder.showOrder();
        restaurantOrder.processOrder();

        System.out.println("------------------");

        RestaurantOrder restaurantOrder2 = new RestaurantOrder(2, "Ümit", 120, false, true);
        restaurantOrder2.orderToPay();
        restaurantOrder2.showOrder();
        restaurantOrder2.processOrder();

        System.out.println("------------------");

        RestaurantOrder restaurantOrder3 = new RestaurantOrder(3, "Ayşe", 200, true, false);
        restaurantOrder3.orderToPay();
        restaurantOrder3.showOrder();
        restaurantOrder3.processOrder();
    }
}