package com.turkcell;

public class Instructor extends Person{
    private String department;
    public Instructor(int id, String firstname, String lastname, String department) {
        super(id, firstname, lastname);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + getId() +
                ", firstname=" + getFirstname() +
                ", lastname=" + getLastname() +
                ", department='" + department + '\'' +
                '}';
    }
}
