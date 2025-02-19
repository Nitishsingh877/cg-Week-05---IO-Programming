package com.bridgelabz.nitish.submissionofJSON.practice_problems.validatejsonstructure;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;

public class ValidateJSON {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String filePath = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\Day02_JSON_Data\\src\\main\\resources\\schema.json";

        JsonNode jsonNode = objectMapper.readTree(new File(filePath));

        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();

        JsonSchema schema = factory.getJsonSchema(jsonNode);
        String fileMatch = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\Day02_JSON_Data\\src\\main\\resources\\enployee.json";
        //load json data
        JsonNode jsonData = objectMapper.readTree(new File(fileMatch));

        //validate json
        if(schema.validate(jsonData).isSuccess()){
            System.out.println("Json is valid");
        }else {
            System.out.println("Invalid json format");
        }

    }
}
