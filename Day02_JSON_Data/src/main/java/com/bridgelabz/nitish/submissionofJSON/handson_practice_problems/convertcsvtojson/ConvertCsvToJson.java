package com.bridgelabz.nitish.submissionofJSON.handson_practice_problems.convertcsvtojson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConvertCsvToJson {
    public static void ConvertCSVtoJson(String csvfile, String jsonfile) throws IOException{
        JSONArray jsonArray =new JSONArray();

        try(BufferedReader br = new BufferedReader(new FileReader(csvfile))) {
            String headerLine = br.readLine();

            String[] header = headerLine.split(",");
            String line;
            while ((line = br.readLine())!= null){
                String[] value = line.split(",");
                JSONObject jsonObject = new JSONObject();

                int length  = Math.min(header.length, value.length);

                for (int i = 0; i < length ; i++){
                    jsonObject.put(header[i].trim(), value[i].trim());
                }jsonArray.put(jsonObject);
            }

        }
        try (FileWriter writer = new FileWriter(jsonfile)){
            writer.write(jsonArray.toString(2));
        }
    }

    public static void main(String[] args) {
        String csvFile = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\Day02_JSON_Data\\src\\main\\resources\\data.csv";
        String jsonFile = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\Day02_JSON_Data\\src\\main\\resources\\data.json";

        try {
            ConvertCSVtoJson(csvFile,jsonFile);
            System.out.println("successfully converted");
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
