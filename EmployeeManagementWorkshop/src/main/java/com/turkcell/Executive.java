package com.turkcell;

public class Executive extends Employee {
    private double stockOptions;

    public Executive(String name, String department, double salary, double stockOptions) {
        super(name, department, salary);
        this.stockOptions = stockOptions;
    }

    public double getStockOptions() {
        return stockOptions;
    }

    public void setStockOptions(double stockOptions) {
        this.stockOptions = stockOptions;
    }
}
