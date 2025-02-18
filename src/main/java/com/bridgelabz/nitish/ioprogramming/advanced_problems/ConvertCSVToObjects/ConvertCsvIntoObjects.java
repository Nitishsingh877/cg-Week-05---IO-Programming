package com.bridgelabz.nitish.ioprogramming.advanced_problems.ConvertCSVToObjects;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.util.List;

public class ConvertCsvIntoObjects {
    public static void main(String[] args) {
        String filePath  = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\Week05-IOProgramming\\src\\main\\resources\\Student.csv";

        try (FileReader reader = new FileReader(filePath)){
            CsvToBean<Student> csvToBean = new CsvToBeanBuilder<Student>(reader)
                    .withType(Student.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Student> students = csvToBean.parse();

            for (Student student : students){
                System.out.println(student.getName() + " studies " + student.getCourse()+ " ,with id  " + student.getId());
            }
        }catch (Exception e){
            System.out.println("error while file parsing"  + e.getMessage());
        }
    }

}
