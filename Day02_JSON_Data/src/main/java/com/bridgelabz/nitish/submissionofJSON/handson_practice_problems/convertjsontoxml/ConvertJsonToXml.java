package com.bridgelabz.nitish.submissionofJSON.handson_practice_problems.convertjsontoxml;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertJsonToXml {

    public static  void ConvertJsonToXml(String jsonFilePath, String xmlFilePAth) throws  Exception{
        String json = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
        try {
            //single json
            JSONObject jsonObject = new JSONObject(json);
            String xml = XML.toString(jsonObject);
            try (FileWriter writer = new FileWriter(xmlFilePAth)){
                writer.write(xml);
            }
        }catch (org.json.JSONException e){
            // If it's not a single object, try converting as a JSON array:
            try {
                JSONArray jsonArray = new JSONArray(json);
                JSONObject root = new JSONObject();
                root.put("data",jsonArray);

                String xml = XML.toString(root);
                try (FileWriter writer = new FileWriter(xmlFilePAth)) {
                    writer.write(xml);
                }

            } catch (org.json.JSONException e2) {
                throw new org.json.JSONException("Invalid JSON format. The JSON must be a single object or an array of objects.");
            }
        }
        }

    public static void main(String[] args) {

        String fileJson = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\Day02_JSON_Data\\src\\main\\resources\\convert.json";
        String filexml = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\Day02_JSON_Data\\src\\main\\resources\\convert.xml";

        try {
            ConvertJsonToXml(fileJson,filexml);
            System.out.println("JSON to XML conversion successful");
        }catch (Exception e){
            System.err.println("Error" + e.getMessage());
            e.printStackTrace();
        }
    }
}
