package com.bridgelabz.nitish.submissionofJSON.ipledition;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.FileWriter;

public class JsonCensor {
    public static void JsonCensorContent(String JsonPath, String jsonPathModified)throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File(JsonPath));

        if(jsonNode.isArray()){
            ArrayNode jsonArray = (ArrayNode) jsonNode;

            for(JsonNode element : jsonArray){
                if(element.isObject()){
                    ObjectNode matchObject = (ObjectNode) element;

                    // Censor team1, team2, and winner fields
                    censorField(matchObject, "team1");
                    censorField(matchObject, "team2");
                    censorField(matchObject, "winner");

                    // Redact the player_of_match field
                    matchObject.put("player_of_match", "REDACTED");
                }
            }
            // Write the modified JSON to a new file
            try (FileWriter fileWriter = new FileWriter(jsonPathModified)) {
                fileWriter.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray));
            }
        } else {
            throw new IllegalArgumentException("The JSON file must contain an array of objects.");
        }
        }

    private static void censorField(ObjectNode objectNode, String fieldName) {
        if (objectNode.has(fieldName)) {
            String team = objectNode.get(fieldName).asText();
            String censoredTeam = censorTeam(team);
            objectNode.put(fieldName, censoredTeam);
        }
    }
    private static String censorTeam(String team) {
        String[] words = team.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(words[0]).append(" "); // Keep the first word as is

        // Censor the remaining words
        for (int i = 1; i < words.length; i++) {
            String censored = "*".repeat(words[i].length());
            sb.append(censored);
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }


}

