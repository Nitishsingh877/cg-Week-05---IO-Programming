package com.bridgelabz.nitish.ioprogramming.basic_problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCsvFile {
    public static void main(String[] args) throws IOException {
        String filePath  = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\src\\main\\resources\\read.csv";
        BufferedReader br = null;
        String line;

        try {
            br  = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null){
                String[] index = line.split(",");
                System.out.printf("%-10s %-20s %-5s %-5s\n ", index[0], index[1],index[2],index[3]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            br.close();
        }
    }
}
