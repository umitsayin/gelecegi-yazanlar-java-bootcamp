package com.turkcell;

public class Engineer extends Employee {
    private String jobTitle;

    public Engineer(String name, String department, double salary, String jobTitle) {
        super(name, department, salary);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
