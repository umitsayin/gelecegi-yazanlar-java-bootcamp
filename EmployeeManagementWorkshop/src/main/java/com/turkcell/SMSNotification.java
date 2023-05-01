package com.turkcell;

public class SMSNotification implements Notification {

    @Override
    public void sendNotify() {
        System.out.println("Bildirim sms ile iletildi!");
    }
}
