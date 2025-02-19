package com.bridgelabz.nitish.ioprogramming.advanced_problems.jsoncsvconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class JsonCsvConvertor {

    public static void jsonToCsv(String jsonFilePath,String csvFilepath) throws IOException {
        String json = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
        JSONArray jsonArray = new JSONArray(json);

        try (FileWriter writer = new FileWriter(csvFilepath)) {
            // Write header row (if needed)
            if (jsonArray.length() > 0) {
                JSONObject firstObject = jsonArray.getJSONObject(0);
                Iterator<String> keys = firstObject.keys();
                while (keys.hasNext()) {
                    writer.append(keys.next());
                    if (keys.hasNext()) {
                        writer.append(",");
                    }
                }
                writer.append("\n");
            }
            // Write data rows
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Iterator<String> keys = jsonObject.keys();// reuse the iterator
                while (keys.hasNext()) {
                    String key = keys.next();
                    writer.append(jsonObject.get(key).toString());
                    if (keys.hasNext()) {
                        writer.append(",");
                    }
                }
                writer.append("\n");
            }
        }
    }

    public static void csvToJson(String csvFilePath, String jsonFilePath) throws IOException, JSONException {
        JSONArray jsonArray = new JSONArray();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String headerLine = reader.readLine(); // Read header row
            String[] headers = headerLine.split(",");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                JSONObject jsonObject = new JSONObject();

                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i].trim(), values[i].trim()); // Trim whitespace
                }
                jsonArray.put(jsonObject);
            }
        }

        try (FileWriter writer = new FileWriter(jsonFilePath)) {
            writer.write(jsonArray.toString(2)); // Use toString(2) for pretty printing
        }
    }


    public static void main(String[] args) {
        String jsonFile = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\src\\main\\resources\\students.json";
        // Example JSON file path
        String csvFile = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\src\\main\\resources\\students.csv";   // Output CSV file path
        String jsonOutput = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\src\\main\\resources\\students_from_csv.json"; // JSON file path from CSV

        try {
            jsonToCsv(jsonFile, csvFile);
            System.out.println("JSON to CSV conversion successful!");

            csvToJson(csvFile, jsonOutput);
            System.out.println("CSV to JSON conversion successful!");

        } catch (IOException | JSONException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
