package com.java.functionalinterface;

import com.java.data.Student;
import com.java.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
  static Consumer<Student> studentConsumer = (student -> System.out.println(student));
  static Consumer<Student> nameConsumer = (student -> System.out.print(student.getName()));
  static Consumer<Student> activitiesConsumer = (student -> System.out.println(student.getActivities()));

  public static void printStudent() {
    List<Student> studentList = StudentDataBase.getAllStudents();
    studentList.forEach(studentConsumer);
  }

  public static void printNameAndActivities(){
    System.out.println("printNameAndActivities: ");
    List<Student> studentList = StudentDataBase.getAllStudents();
    studentList.forEach(nameConsumer.andThen(activitiesConsumer)); //consumer chaining
  }
  public static void printNameAndActivitiesUsingConditions(){
    System.out.println("printNameAndActivitiesUsingConditions: ");
    List<Student> studentList = StudentDataBase.getAllStudents();
    studentList.forEach(student -> {
      if(student.getGradeLevel()>=3 && student.getGpa()>=3.9){
        nameConsumer.andThen(activitiesConsumer).accept(student);
      }
    });
  }

  public static void main(String[] args) {
    //
    Consumer<String> c1 = (s)->System.out.println(s.toUpperCase());
    c1.accept("java8");
    printStudent();
    printNameAndActivities();
    printNameAndActivitiesUsingConditions();
  }
}
