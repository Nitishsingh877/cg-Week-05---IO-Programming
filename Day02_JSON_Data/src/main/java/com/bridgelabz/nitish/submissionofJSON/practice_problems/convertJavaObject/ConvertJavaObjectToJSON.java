package com.bridgelabz.nitish.submissionofJSON.practice_problems.convertJavaObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

class Car {
    private String modelName;
    private int modelyYear;

    public Car(String modelName, int modelyYear) {
        this.modelyYear = modelyYear;
    }

    public int getModelyYear() {
        return modelyYear;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelyYear(int modelyYear) {
        this.modelyYear = modelyYear;
    }
}
public class ConvertJavaObjectToJSON {
    public static void main(String[] args) {
       try {
           List<Car> carList = new ArrayList<>();
           Car car = new Car("BMW", 2021);
           Car car1 = new Car("aura",2021);
           Car car2 = new Car("xml",2025);
           carList.add(car1);
           carList.add(car2);
           carList.add(car);
           ObjectMapper objectMapper = new ObjectMapper();
           //convert java object to json
           String jsonString  = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(carList);
           System.out.println(jsonString);
       }catch (Exception e){
           e.getMessage();
       }


    }
}
