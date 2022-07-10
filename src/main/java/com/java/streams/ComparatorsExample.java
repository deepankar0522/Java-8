package com.java.streams;

import com.java.data.Student;
import com.java.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class ComparatorsExample {
    static List<Student> studentList = StudentDataBase.getAllStudents();
static Consumer<Student> studentConsumer = student -> System.out.println(student);
    static void sortByName(List<Student> students) {
        students.sort(Comparator.comparing(Student::getName));
        students.forEach(studentConsumer);
    }

    static void sortByGpa(List<Student> students) {
        students.sort(Comparator.comparing(Student::getGpa));
        students.forEach(studentConsumer);
    }

    static void sortByGpaDesc(List<Student> students) {
        students.sort(Comparator.comparing(Student::getGpa).reversed());
        students.forEach(studentConsumer);
    }

    static void sortByChaining(List<Student> students) {
        students.sort(Comparator.comparing(Student::getGender).thenComparing(Student::getName));
        students.forEach(studentConsumer);
    }

    public static void main(String[] args) {
//        sortByName(studentList);
//        sortByGpa(studentList);
//        sortByGpaDesc(studentList);
        sortByChaining(studentList);
    }
}
