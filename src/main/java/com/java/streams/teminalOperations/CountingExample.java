package com.java.streams.teminalOperations;

import com.java.data.StudentDataBase;

import java.util.stream.Collectors;

public class CountingExample {

    public static Long count(){
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa()>3.9)
                .collect(Collectors.counting());
    }

    public static void main(String[] args) {
        System.out.println(count());
    }
}
