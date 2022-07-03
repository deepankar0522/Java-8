package com.java.streams.teminalOperations;

import com.java.data.Student;
import com.java.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupByExample {

    public static Map<String, List<Student>> groupByGender() {
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGender));
    }

    public static Map<String, List<Student>> groupByGpa() {
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "Outstanding" : "Average"));
    }

    public static Map<Integer, Map<String, List<Student>>> twoLevelGroup() {
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "Outstanding" : "Average")));
    }

    public static Map<Integer, Student> getTopStudentByGradeLevel() {
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)), Optional::get)));
    }

    public static void main(String[] args) {
        System.out.println(groupByGender());
        System.out.println(groupByGpa());
        System.out.println(twoLevelGroup());
    }
}
