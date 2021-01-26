package com.java.streams;

import com.java.data.Student;
import com.java.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class StreamsMapExample {

  public static List<String> getNamesList() {
    return StudentDataBase.getAllStudents().stream()
        .map(Student::getName)
        .map(String::toUpperCase)
        .collect(toList());
  }

  public static Set<String> getNamesSet() {
    return StudentDataBase.getAllStudents().stream()
        .map(Student::getName)
        .map(String::toUpperCase)
        .collect(toSet());
  }

  public static void main(String[] args) {
    System.out.println(getNamesList());
    System.out.println(getNamesSet());
  }
}
