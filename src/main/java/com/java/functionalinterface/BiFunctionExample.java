package com.java.functionalinterface;

import com.java.data.Student;
import com.java.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {
  static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> studentBiFunction = ((students, studentPredicate) -> {
        Map<String, Double> studentGrademap = new HashMap<>();
        students.forEach(student -> {
              if (studentPredicate.test(student))
                studentGrademap.put(student.getName(), student.getGpa());
            });
        return studentGrademap;
      });

  public static void main(String[] args) {
    System.out.println(studentBiFunction.apply(StudentDataBase.getAllStudents(), PredicateStudentExample.p1));
  }
}
