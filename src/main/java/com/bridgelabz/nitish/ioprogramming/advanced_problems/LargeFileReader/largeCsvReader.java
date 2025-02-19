package com.bridgelabz.nitish.ioprogramming.advanced_problems.LargeFileReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class largeCsvReader {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Container\\100b.csv";

        int chunksize = 100;
        long totalRecordProcessed = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String line;
            bufferedReader.readLine();

            while ((line = bufferedReader.readLine())!= null) {
                int recordsInchunk = 0;
                while (recordsInchunk < chunksize && line != null) {
                    totalRecordProcessed++;
                    recordsInchunk++;
                    line = bufferedReader.readLine();
                }

                System.out.println("Processed " + recordsInchunk + "record in this chunks");
            }
        }
        System.out.println("Total records processed " + totalRecordProcessed);

    }
}
