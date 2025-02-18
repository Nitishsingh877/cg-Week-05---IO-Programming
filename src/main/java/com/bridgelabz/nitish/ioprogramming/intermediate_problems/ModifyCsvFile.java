package com.bridgelabz.nitish.ioprogramming.intermediate_problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ModifyCsvFile {
    public static void main(String[] args) {
        String filePath  = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\src\\main\\resources\\employees.csv";
        String fileWritePath  = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\src\\main\\resources\\UpdatedEmployees.csv";

        BufferedReader bufferedReader = null;
        List<String> updatedLines = new ArrayList<>();

        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] strings = line.split(",");

                if(strings.length>0 && !strings[0].equals("Name")){
                    String department = strings[1].trim();

                    if(department.equals("IT")){
                        try {
                            double salary = Double.parseDouble(strings[2].trim());
                            double updatedSalary = salary * 1.10;
                            strings[2] = String.format("%.2f",updatedSalary);
                        }catch (NumberFormatException e){
                            System.err.println("Error parsing salary :" + line);
                        }
                    }
                }  updatedLines.add(String.join(",",strings));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileWritePath))){
            writer.write("Name,Department,Salary");
            for (String line : updatedLines){
                writer.write(line);
                writer.newLine();
            }
            System.out.println("CSV file updated and saved!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
