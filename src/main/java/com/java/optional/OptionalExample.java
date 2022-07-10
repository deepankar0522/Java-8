package com.java.optional;

import com.java.data.Student;
import com.java.data.StudentDataBase;

import java.util.Optional;

public class OptionalExample {
    public static String getStudentName(){
        // Student student = StudentDataBase.studentSupplier.get();
        Student student = null;
        if(student!=null)
            return  student.getName();
        else
            return  null;
    }

    public static Optional<String> getStudentNameOptional(){
        Optional<Student> student = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        //Optional<Student> student = Optional.ofNullable(null);
        if(student.isPresent()){
            return  student.map(Student::getName); // don't get confused this with streams map method. Both are different.
        }
        return Optional.empty();
    }

    public static String optionalOrElse(){
        //Optional<Student> getOptionalStudent = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> optionalStudent = Optional.ofNullable(null);
        String name =  optionalStudent.map(Student::getName).orElse("Default");
        return name;
    }

    public static String optionalOrElseGet(){
        //Optional<Student> getOptionalStudent = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> optionalStudent = Optional.ofNullable(null);
        String name =  optionalStudent.map(Student::getName).orElseGet(()->"Default");
        return name;
    }

    public static String optionalOrElseThrow(){
        //Optional<Student> getOptionalStudent = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> optionalStudent = Optional.ofNullable(null);
        String name =  optionalStudent.map(Student::getName).orElseThrow(()->new RuntimeException("No Data available"));
        return name;
    }

    public static void main(String[] args) {
        if(getStudentNameOptional().isPresent())
            System.out.println(getStudentNameOptional().get());
        else
            System.out.println("Name is returned as empty.");
    }
}
