package com.turkcell;

public class Application {

    public static void main(String[] args) {
        Account account = new Account(1,"Ümit", "Sayın",12000);

        account.pushAmount(0);
        System.out.println(account.toString());
    }
}
