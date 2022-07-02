package com.java.streams.teminalOperations;

import com.java.data.Student;
import com.java.data.StudentDataBase;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class MinByMaxByExample {

    public static Optional<Student> getMax(){
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.maxBy(Comparator.comparing(student -> student.getGpa())));
    }

    public static Optional<Student> getMin(){
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.minBy(Comparator.comparing(student -> student.getGpa())));
    }
    public static void main(String[] args) {
        System.out.println(getMax());
        System.out.println(getMin());

    }
}
