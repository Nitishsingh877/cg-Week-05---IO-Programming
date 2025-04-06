package com.bridgelabz.nitish.submissionofJSON.ipledition;

public class Main {
    public static void main(String[] args) throws Exception {
        String iplFilejson ="C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\Day02_JSON_Data\\src\\main\\resources\\ipl.json";
        String modifiediplJson = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\Day02_JSON_Data\\src\\main\\resources\\modifiedIpl.json";
        String csvIpl = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\Day02_JSON_Data\\src\\main\\resources\\ipl.csv";
        String modifiedCsvIpl = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\Day02_JSON_Data\\src\\main\\resources\\ModifiedIpl.csv";

        CsvCensor.censorCsvContent(csvIpl,modifiedCsvIpl);
        JsonCensor.JsonCensorContent(iplFilejson,modifiediplJson);

    }
}
