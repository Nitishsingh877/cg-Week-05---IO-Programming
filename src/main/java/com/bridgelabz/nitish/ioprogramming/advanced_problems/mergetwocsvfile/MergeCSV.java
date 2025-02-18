package com.bridgelabz.nitish.ioprogramming.advanced_problems.mergetwocsvfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class MergeCSV {
    public static void main(String[] args) {
        String student1path  = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\src\\main\\resources\\students1.csv";
        String student2Path  = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\src\\main\\resources\\students2.csv";
        String mergedStudent  = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\src\\main\\resources\\merged.csv";


        try(BufferedReader br1 = new BufferedReader(new FileReader(student1path));
             BufferedReader br2 = new BufferedReader(new FileReader(student2Path));
             BufferedWriter br = new BufferedWriter(new FileWriter(mergedStudent)))
             {

            String line;
            Map<String , String[]> student1Data = new HashMap<>();
            br1.readLine();
           while ((line = br1.readLine()) != null){
              String[] fields = line.split(",");
              if(fields.length>0){
                  student1Data.put(fields[0].trim(),fields);
              }
           }

           br2.readLine();
           br.write("ID,Name,Age,Marks,Grade");
           br.newLine();

           while ((line = br2.readLine()) != null){
              String[] fields2 = line.split(",");
              if(fields2.length > 0){
                  String  id = fields2[0].trim();
                  String[] fields1 = student1Data.get(id);

                  if(fields1 != null){
                      br.write(id+ "," + fields1[1] + "," + fields1[2] + ","+fields2[1] + "," + fields2[2]);
                      br.newLine();
                  }
              }
           }

            System.out.println("CSV files merged successfully");


        }catch (Exception e){
            e.getMessage();
        }

    }
}
