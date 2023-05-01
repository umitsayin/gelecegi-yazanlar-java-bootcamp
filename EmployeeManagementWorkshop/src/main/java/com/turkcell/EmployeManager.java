package com.turkcell;

public class EmployeManager {
    private final Notification[] notifications;

    public EmployeManager(Notification[] notifications) {
        this.notifications = notifications;
    }

    public void add(Employee employee) {
        System.out.println(employee.getName() + " sisteme eklendi");
        for (Notification notification : notifications) {
            notification.sendNotify();
        }
    }

    public void addMultiple(Employee[] employees) {
        for (Employee employee : employees) {
            add(employee);
        }
    }
}
