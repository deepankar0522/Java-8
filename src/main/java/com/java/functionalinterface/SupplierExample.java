package com.java.functionalinterface;

import com.java.data.Student;
import com.java.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

  public static Supplier<Student> studentSupplier = () -> {
        return new Student(
            "Adam", 2, 4.0, "male",5, Arrays.asList("swimming", "basketball", "volleyball"));
      };

  public static Supplier<List<Student>> studentsSupplier = () -> StudentDataBase.getAllStudents();

  public static void main(String[] args) {
    Student student = studentSupplier.get();
    System.out.println("Student is : " + student);
    System.out.println("Students are : " + studentsSupplier.get());
  }
}
