package com.bridgelabz.nitish.submissionofJSON.practice_problems;
import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJsonObject {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();

        JSONArray subjects = new JSONArray();
        subjects.put("English");
        subjects.put("Hindi");
        subjects.put("sanskrit");

        
        jsonObject.put("name" , "Nitish singh");
        jsonObject.put("age",18);
        jsonObject.put("Subjects", subjects);


        System.out.println(jsonObject.toString());

    }
}
