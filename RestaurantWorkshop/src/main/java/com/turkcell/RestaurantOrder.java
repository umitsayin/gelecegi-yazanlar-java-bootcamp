package com.turkcell;

public class RestaurantOrder {
    private int orderId;
    private String customerName;
    private double totalPrice;
    private boolean isDelivery;
    private boolean isPaid;

    public RestaurantOrder(int orderId, String customerName, double totalPrice, boolean isDelivery, boolean isPaid) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.isDelivery = isDelivery;
        this.isPaid = isPaid;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isDelivery() {
        return isDelivery;
    }

    public void setDelivery(boolean delivery) {
        isDelivery = delivery;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }


    public void orderToPay() {
        if (isPaid)
            System.out.println("Payment completed!");
        else
            System.out.println("Payment not completed!");
    }

    public void cancelOrder() {
        totalPrice = 0;
        isPaid = false;

        System.out.println("Your order has been canceled");
    }

    @Override
    public String toString() {
        return "RestaurantOrder{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                ", isDelivery=" + isDelivery +
                ", isPaid=" + isPaid +
                '}';
    }

    public void showOrder(){
        System.out.println(toString());
    }

    public void processOrder() {
        if (isDelivery) {
            if (isPaid) {
                System.out.println("Order has been delivered");
            } else {
                System.out.println("You need to pay");
            }
        } else
            System.out.println("Order can be taken from the restaurant");
    }
}
