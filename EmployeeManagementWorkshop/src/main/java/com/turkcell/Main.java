package com.turkcell;

public class Main {
    public static void main(String[] args) {
        Engineer engineer = new Engineer("Tunahan", "IT", 20000, "Backend-dev");
        Manager manager = new Manager("Burak", "IT", 17500, 1200000);
        Executive executive = new Executive("Engin", "IT", 50000, 10000);

        EmployeManager employeManager = new EmployeManager(new Notification[]
                {new SMSNotification(), new EmailNotification()});

        employeManager.addMultiple(new Employee[]{engineer, manager, executive});
    }
}