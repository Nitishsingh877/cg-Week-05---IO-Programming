package com.bridgelabz.nitish.ioprogramming.advanced_problems.ConvertCSVToObjects;

import com.opencsv.bean.CsvBindByName;

public class Student {
    @CsvBindByName(column = "name") //map name column
    private String name;
    @CsvBindByName(column = "course")
    private String course;
    @CsvBindByName(column = "id")
    private String id;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", id=" + id +
                '}';
    }
}
