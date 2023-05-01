package com.turkcell;

public class Account {
    private int id;
    private String firstname;
    private String lastname;
    private int amount;

    public Account(int id, String firstname, String lastname, int amount) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void pullAmount(int amount){
        if(this.amount <= 0 || amount > this.amount)
            System.out.println("Bakiye yetersiz.");
        else{
            this.amount -= amount;
        }
    }

    public void pushAmount(int amount){
        if(amount <= 0){
            System.out.println("Miktar 0'dan büyük olmalıdır.");
        }else{
            this.amount += amount;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", amount=" + amount +
                '}';
    }
}
