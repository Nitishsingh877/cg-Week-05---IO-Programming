package com.bridgelabz.nitish.ioprogramming.intermediate_problems;

import java.io.BufferedReader;
import java.io.FileReader;

public class SearchRecordsInCsv {
    public static void main(String[] args) {
        String filePath  = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\src\\main\\resources\\employees.csv";
        BufferedReader bufferedReader = null;
        String line;

        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            while ((line = bufferedReader.readLine()) != null){
                String[] strings = line.split(",");
                if(strings[0].equals("Neha Gupta")){
                    System.out.println("department is : " +strings[1] + ". Salary is  " + strings[2]);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
