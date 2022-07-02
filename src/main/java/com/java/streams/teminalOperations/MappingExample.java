package com.java.streams.teminalOperations;

import com.java.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MappingExample {

    public static void main(String[] args) {

        List<String> list = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.mapping(student -> student.getName(), Collectors.toList()));
        System.out.println(list);

        Set<String> set = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.mapping(student -> student.getName(), Collectors.toSet()));
        System.out.println(set);
    }
}
