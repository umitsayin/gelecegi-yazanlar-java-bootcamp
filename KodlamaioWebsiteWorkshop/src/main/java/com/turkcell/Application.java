package com.turkcell;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Category category = new Category(1,"Backend Development");
        Instructor instructor = new Instructor(10,"Engin","Demiroğ","Yazılım Geliştirici");
        Course course = new Course();

        List<Student> studentList = new ArrayList<>();
        Student student = new Student(1,"Test firstname","Test lastname",0);
        studentList.add(student);

        course.setId(1);
        course.setDescription("Turkcell geleceği yazanlar java kampı");
        course.setName("Java 1");
        course.setCategory(category);
        course.setInstructor(List.of(instructor));
        course.setStudents(studentList);

        System.out.println(course);
    }
}
