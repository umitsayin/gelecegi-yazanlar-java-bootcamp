package com.turkcell;

public class Student extends Person{
    private int score;

    public Student(int id, String firstname, String lastname, int score) {
        super(id, firstname, lastname);
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", firstname=" + getFirstname() +
                ", lastname=" + getLastname() +
                ", score=" + score +
                '}';
    }
}
