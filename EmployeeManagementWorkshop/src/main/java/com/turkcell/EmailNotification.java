package com.turkcell;

public class EmailNotification implements Notification {
    @Override
    public void sendNotify() {
        System.out.println("Bildirim eposta ile iletildi.");
    }
}

