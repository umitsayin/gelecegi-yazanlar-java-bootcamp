package com.turkcell.model;

public class Player {
    private int id;
    private String firstName;
    private String lastName;
    private int birthYear;
    private String nationalIdentity;

    public Player() {
    }

    public Player(int id, String firstName, String lastName, int birthYear, String nationalIdentity) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.nationalIdentity = nationalIdentity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public void setNationalIdentity(String nationalIdentity) {
        this.nationalIdentity = nationalIdentity;
    }
}
