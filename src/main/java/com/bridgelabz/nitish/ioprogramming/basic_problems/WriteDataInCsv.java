package com.bridgelabz.nitish.ioprogramming.basic_problems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataInCsv {
    public static void main(String[] args) throws IOException {
        String filePath  = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\src\\main\\resources\\write.csv";
        BufferedWriter bufferedWriter = null;
        String line;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            bufferedWriter.write("ID,Name,Age,Marks\n");
            bufferedWriter.write("12,Pooja Sharma,25,91\n");
            bufferedWriter.write("13,Rajesh Kumar,29,76\n");
            bufferedWriter.write("14,Kavita Singh,22,87\n");
            bufferedWriter.write(" 15,Amit Patel,26,93\n");
            System.out.println("successfully written in csv file!!");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bufferedWriter.close();
        }

    }
}
