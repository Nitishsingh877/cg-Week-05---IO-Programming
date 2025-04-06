package com.bridgelabz.nitish.ioprogramming.advanced_problems.genratecsv;

public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private int salary;

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public Employee(String employeeId, String name, String department, int salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}
