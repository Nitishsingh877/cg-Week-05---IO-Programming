package com.bridgelabz.nitish.submissionofJSON.practice_problems.convertJavaobjectintojsonarray;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Student student = new Student("nitish ", 45);
        Student student1 = new Student("siddhu",60);
        studentList.add(student);
        studentList.add(student1);

        JSONArray jsonArray = new JSONArray();

        for(Student students : studentList){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name" , students.getName());
            jsonObject.put("age" , students.getAge());
            jsonArray.put(jsonObject);
        }
        System.out.println(jsonArray.toString(2));
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
