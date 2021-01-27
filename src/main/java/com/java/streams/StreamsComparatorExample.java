package com.java.streams;

import com.java.data.Student;
import com.java.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsComparatorExample {

    public static List<Student> getStudentByName(){
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    public static List<Student> getStudentByGpa(){
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .collect(Collectors.toList());
    }

    public static List<Student> getStudentByGpaDesc(){
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
    System.out.println("getStudentByName: ");
        getStudentByName().forEach(System.out::println);
        System.out.println("getStudentByGpa: ");
        getStudentByGpa().forEach(System.out::println);
        System.out.println("getStudentByGpaDesc: ");
        getStudentByGpaDesc().forEach(System.out::println);
  }
}
