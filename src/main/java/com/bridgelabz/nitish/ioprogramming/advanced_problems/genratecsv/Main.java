package com.bridgelabz.nitish.ioprogramming.advanced_problems.genratecsv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("E001", "Alice Johnson", "Sales", 60000));
        employees.add(new Employee("E002", "Bob Williams", "Marketing", 70000));
        employees.add(new Employee("E003", "Charlie Brown", "Engineering", 80000));
        employees.add(new Employee("E004", "David Lee", "HR", 55000));
        employees.add(new Employee("E005", "Eve Davis", "Finance", 90000));
        employees.add(new Employee("E006", "Frank Wilson", "Sales", 65000));
        employees.add(new Employee("E007", "Grace Garcia", "Marketing", 75000));
        employees.add(new Employee("E008", "Henry Rodriguez", "Engineering", 85000));
        employees.add(new Employee("E009", "Ivy Martinez", "HR", 60000));
        employees.add(new Employee("E010", "Jack Anderson", "Finance", 95000));
        employees.add(new Employee("E011", "Kelly Taylor", "Sales", 70000));
        employees.add(new Employee("E012", "Larry Thomas", "Marketing", 80000));
        employees.add(new Employee("E013", "Mia Moore", "Engineering", 90000));
        employees.add(new Employee("E014", "Noah Jackson", "HR", 65000));
        employees.add(new Employee("E015", "Olivia Martin", "Finance", 100000));


        String path = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\src\\main\\resources\\employees.csv";
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
            StringBuilder sb = new StringBuilder();
            bufferedWriter.write("EmployeeID,Name,Department,Salary");
            bufferedWriter.newLine();
            for(Employee employee : employees){
                String id = employee.getEmployeeId();
                String name = employee.getName();
                String department = employee.getDepartment();
                String salary = String.valueOf(employee.getSalary());

                String line = id+","+name+","+department+","+salary;
                bufferedWriter.write(line);
                bufferedWriter.newLine();

            }
            System.out.println("Employee data written successfully as csv ");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }

