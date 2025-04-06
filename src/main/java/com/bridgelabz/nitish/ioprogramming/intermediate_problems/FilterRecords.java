package com.bridgelabz.nitish.ioprogramming.intermediate_problems;

import java.io.BufferedReader;
import java.io.FileReader;

public class FilterRecords {
    public static void main(String[] args) {
        String filePath  = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\src\\main\\resources\\read.csv";
        BufferedReader bufferedReader = null;
        String line;

        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            bufferedReader.readLine(); //discard head
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");

                if (strings.length > 3) {
                    try {
                        int value = Integer.parseInt(strings[3].trim());
                        if (value > 80) {
                            System.out.println("name is " + strings[1] + " marks is : " + strings[3]);
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("incomplete line!!");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
