package com.bridgelabz.nitish.ioprogramming.advanced_problems;

import javax.sql.rowset.serial.SerialStruct;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeleteDuplicates {
    public static void main(String[] args){
        String filePath = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\src\\main\\resources\\duplicate.csv";
        String line;
        Map<String, List<String[]>> map = new HashMap<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null){
                String[] fields = line.split(",");
                String id = fields[0];

                if(!map.containsKey(id)){
                    map.put(id,new ArrayList<>());
                }
                map.get(id).add(fields);
            }

            System.out.println("\n duplicates are :");
            for(Map.Entry<String,List<String[]>> entry : map.entrySet()){
                if(entry.getValue().size() > 1){
                    System.out.println("ID " + entry.getKey());
                    for (String[] records : entry.getValue()){
                        for (String field : records){
                            System.out.print(field + ",");
                        }
                        System.out.println();
                    }
                }
            }

        }catch (Exception e){
            e.getMessage();
        }

    }
}
