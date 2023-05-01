package com.turkcell;

public class Manager extends Employee {
    private double projectBudget;

    public Manager(String name, String department, double salary, double projectBudget) {
        super(name, department, salary);
        this.projectBudget = projectBudget;
    }

    public double getProjectBudget() {
        return projectBudget;
    }

    public void setProjectBudget(double projectBudget) {
        this.projectBudget = projectBudget;
    }
}
