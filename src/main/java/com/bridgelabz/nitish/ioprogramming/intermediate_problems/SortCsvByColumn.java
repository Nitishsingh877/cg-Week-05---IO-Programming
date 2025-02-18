package com.bridgelabz.nitish.ioprogramming.intermediate_problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;

public class SortCsvByColumn {
    static  class Employee{
        String name;
        String department;
        double salary;

        public Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", department='" + department + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }


    public static void main(String[] args) {
        String filePath  = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\src\\main\\resources\\employees.csv";
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String line;
            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null){
                String[] fields = line.split(",");

                if(fields.length >= 3){
                    try {
                        String name = fields[0].trim();
                        String department = fields[1].trim();
                        double salary = Double.parseDouble(fields[2].trim());
                        employees.add(new Employee(name,department,salary));
                    }catch (NumberFormatException e){
                        System.out.println("error parsing salary " + line);
                    }
                }else {
                    System.out.println("incomplete line");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //sort
        Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary).reversed());

        System.out.println("TOP 5 Salary is ");
        int count = 0;
        for (Employee employee : employees){
            System.out.println(employee);
            count++;
            if(count >= 5 ){
                break;
            }
        }
    }

}
