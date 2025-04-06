package com.bridgelabz.nitish.submissionofJSON.practice_problems.mergetwoJsonObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.management.ObjectName;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        String json1 = "{\"name\":\"Alice\", \"age\":30}";
        String json2 = "{\"city\":\"New York\", \"occupation\":\"Software Engineer\"}";

        JsonNode node1 = objectMapper.readTree(json1);
        JsonNode node2 = objectMapper.readTree(json2);

        ObjectNode mergedNode = (node1).deepCopy();
        mergedNode.setAll((ObjectNode) node2);

        String mergedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode);
        System.out.println(mergedJson);

    }
}
