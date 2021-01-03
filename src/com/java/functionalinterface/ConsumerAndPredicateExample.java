package com.java.functionalinterface;

import com.java.data.Student;
import com.java.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerAndPredicateExample {

  Predicate<Student> p1 = student -> student.getGradeLevel() >= 3;
  Predicate<Student> p2 = student -> student.getGpa() >= 3.9;
  BiConsumer<String, List<String>> listBiConsumer =
      (name, activities) -> System.out.println(name + " : " + activities);

  Consumer<Student> studentConsumer =
      student -> {
        if (p1.and(p2).test(student)) {
          listBiConsumer.accept(student.getName(), student.getActivities());
        };
      };

  public void printNameAndActivities(List<Student> studentList) {
      studentList.forEach(studentConsumer);
  }

  public static void main(String[] args) {

    List<Student> studentList = StudentDataBase.getAllStudents();
    new ConsumerAndPredicateExample().printNameAndActivities(studentList);
  }
}
