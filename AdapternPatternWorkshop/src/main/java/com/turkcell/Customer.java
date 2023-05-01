package com.turkcell;

public class Customer {

    private String firstName;
    private String lastName;
    private int birthYear;
    private String nationalityID;

    public Customer(String firstName, String lastName, int birthYear, String nationalityID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.nationalityID = nationalityID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getNationalityID() {
        return nationalityID;
    }

    public void setNationalityID(String nationalityID) {
        this.nationalityID = nationalityID;
    }
}
