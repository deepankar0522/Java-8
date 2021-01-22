package com.java.functionalinterface;

import com.java.data.Student;
import com.java.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {
  static Predicate<Student> p1 = student -> student.getGradeLevel() >= 3;
  static Predicate<Student> p2 = student -> student.getGpa() >= 3.9;

  public static void filterStudentByGradeLevel() {
    System.out.println("filterStudentByGradeLevel: ");
    List<Student> studentList = StudentDataBase.getAllStudents();
    studentList.forEach(
        student -> {
          if (p1.test(student)) {
            System.out.println(student);
          }
        });
  }

  public static void filterStudentByGpa() {
    System.out.println("filterStudentByGpa: ");
    List<Student> studentList = StudentDataBase.getAllStudents();
    studentList.forEach(
        student -> {
          if (p2.test(student)) {
            System.out.println(student);
          }
        });
  }

  public static void filterStudentAnd() {
    System.out.println("filterStudentAnd: ");
    List<Student> studentList = StudentDataBase.getAllStudents();
    studentList.forEach(
        student -> {
          if (p1.and(p2).test(student)) {
            System.out.println(student);
          }
        });
  }

  public static void filterStudentOr() {
    System.out.println("filterStudentOr: ");
    List<Student> studentList = StudentDataBase.getAllStudents();
    studentList.forEach(
        student -> {
          if (p1.or(p2).test(student)) {
            System.out.println(student);
          }
        });
  }

  public static void filterStudentNegate() {
    System.out.println("filterStudentNegate: ");
    List<Student> studentList = StudentDataBase.getAllStudents();
    studentList.forEach(
        student -> {
          if (p1.or(p2).negate().test(student)) {
            System.out.println(student);
          }
        });
  }

  public static void main(String[] args) {
    filterStudentByGradeLevel();
    filterStudentByGpa();
    filterStudentAnd();
    filterStudentOr();
    filterStudentNegate();
  }
}
