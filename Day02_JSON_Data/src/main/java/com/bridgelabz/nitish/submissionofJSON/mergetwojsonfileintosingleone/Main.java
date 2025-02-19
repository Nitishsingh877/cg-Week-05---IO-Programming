package com.bridgelabz.nitish.submissionofJSON.mergetwojsonfileintosingleone;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception{
        String file1 = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\Day02_JSON_Data\\src\\main\\resources\\file1.json";
        String file2 = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\Day02_JSON_Data\\src\\main\\resources\\file2.json";


        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode node1 = objectMapper.readTree(new File(file1));
        JsonNode node2 = objectMapper.readTree(new File(file2));
        if(node1.isArray() && node2.isArray()){
            ArrayNode arrayNode = objectMapper.createArrayNode();
            arrayNode.addAll((ArrayNode) node1);
            arrayNode.addAll((ArrayNode) node2);

            String mergedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode);
            System.out.println(mergedJson);

        }else {
            ObjectNode mergedNode = (node1).deepCopy();
            mergedNode.setAll((ObjectNode) node2);

            String mergedJSon = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode);
            System.out.println(mergedJSon);
        }


    }
}
