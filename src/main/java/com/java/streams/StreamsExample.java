package com.java.streams;

import com.java.data.Student;
import com.java.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {

    static Predicate<Student> p1 = student -> student.getGradeLevel() >= 3;
    static Predicate<Student> p2 = student -> student.getGpa() >= 3.9;

    public static void main(String[] args) {
        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents().stream()
                .filter(p1)
                .filter(p2)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
    System.out.println(studentMap);
  }
}
