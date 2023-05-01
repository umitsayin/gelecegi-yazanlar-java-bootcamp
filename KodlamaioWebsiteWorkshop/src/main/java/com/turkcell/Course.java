package com.turkcell;

import java.util.List;

public class Course{
    private int id;
    private String imageUrl;
    private String name;
    private String description;
    private Category category;
    private List<Instructor> instructors;
    private List<Student> students;

    public Course() {

    }

    public Course(int id, String imageUrl, String name, String description,Category category, List<Instructor> instructors, List<Student> students) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.description = description;
        this.category = category;
        this.instructors = instructors;
        this.students= students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructor(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> studentList) {
        this.students = students;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl= " + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category.toString() +
                ", instructor=" + instructors.toString() +
                ", studentList=" + students +
                '}';
    }
}
