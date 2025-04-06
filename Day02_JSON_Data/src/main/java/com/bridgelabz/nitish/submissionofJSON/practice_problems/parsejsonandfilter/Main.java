package com.bridgelabz.nitish.submissionofJSON.practice_problems.parsejsonandfilter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String filepath = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\Day02_JSON_Data\\src\\main\\resources\\enployee.json";
            JsonNode jsonNode = objectMapper.readTree(new File(filepath));

            if(jsonNode.isArray()){
                for (JsonNode element : jsonNode){
                    if(element.get("age").asInt()>25)
                        System.out.println(element.toPrettyString());
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
