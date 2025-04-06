package com.bridgelabz.nitish.submissionofJSON.practice_problems.readJsonfiles;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.lang.reflect.Proxy;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String filePath = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\Day02_JSON_Data\\src\\main\\resources\\enployee.json";
        File file = new File(filePath);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Employee> employees = objectMapper.readValue(file, new TypeReference<List<Employee>>() {
            });

            for (Employee employee : employees){
                System.out.println(employee.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Employee {
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
