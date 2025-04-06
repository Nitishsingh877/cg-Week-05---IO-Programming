package com.bridgelabz.nitish.ioprogramming.advanced_problems;

import java.io.BufferedReader;
import java.io.FileReader;

public class ValidateCSVFile {
    public static void main(String[] args) {
        String filePath  = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\src\\main\\resources\\NewEmployees.csv";
        BufferedReader bufferedReader = null;
        String line;


        try {

            bufferedReader = new BufferedReader(new FileReader(filePath));
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine())!= null){
                String[] fields = line.split(",");
                String emailRegex = "^[a-zA-z0-9_.]+@[a-zA-z0-9]+\\.[a-z]{2,}$";
                String phoneRegex = "\\d{10}";

                try {
                    if(!fields[3].matches(emailRegex) || !fields[4].matches(phoneRegex)){
                        System.out.println("either mail or phone is invalid for " + fields[0]);
                    }
                }catch (NumberFormatException e){
                    System.out.println("error while file parsing" + line);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
