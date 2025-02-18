package com.bridgelabz.nitish.ioprogramming.basic_problems;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadAndCountRows {
    public static void main(String[] args) {
        String filePath  = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\src\\main\\resources\\read.csv";
        BufferedReader bufferedReader = null;
        String line;
        int count = -1;

        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
                count++;
                System.out.printf("%-10s %-20s %-5s %-5s" , strings);
                System.out.println();
            }
            System.out.println("Number of rows excluding header is : "+count);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
