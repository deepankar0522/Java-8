package com.java.streams;

import com.java.data.Student;
import com.java.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsFlatMapExample {

  public static List<String> getStudentActivities() {
    return StudentDataBase.getAllStudents().stream()
        .map(Student::getActivities)
        .flatMap(List::stream)
        .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    System.out.println(getStudentActivities());
  }
}
