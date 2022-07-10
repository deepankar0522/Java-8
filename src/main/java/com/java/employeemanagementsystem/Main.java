package com.java.employeemanagementsystem;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        List<Integer> intList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            intList.add(i);
        }

        //How many male and female employees are there in the organization?

        Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        //System.out.println(noOfMaleAndFemaleEmployees);

        //Print the name of all departments in the organization?

        //employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

        //What is the average age of male and female employees?

        Map<String, Double> avgAgeOfMaleAndFemaleEmployees = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        //System.out.println(avgAgeOfMaleAndFemaleEmployees);

        //Get the details of highest paid employee in the organization?
        Optional<Employee> highestPaidEmployeeWrapper = employeeList.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        //System.out.println(highestPaidEmployeeWrapper.toString());

        //Get the names of all employees who have joined after 2015?
        Map<String, Integer> employeesWhoHaveJoinedAfter2015 = employeeList.stream()
                .filter(employee -> employee.yearOfJoining >= 2015)
                .collect(Collectors.toMap(employee -> employee.name, employee -> employee.yearOfJoining));
        //System.out.println(employeesWhoHaveJoinedAfter2015);

        //Count the number of employees in each department?
        Map<String, Long> employeeCountByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        //System.out.println(employeeCountByDepartment);

        //What is the average salary of each department?
        Map<String, Double> avgSalaryOfDepartments = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        //System.out.println(avgSalaryOfDepartments);

        //Get the details of the youngest male employee in the product development department?
        Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper = employeeList.stream()
                .filter(employee -> employee.getDepartment() == "Product Development")
                .collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge)));
        //System.out.println(youngestMaleEmployeeInProductDevelopmentWrapper);

        //Who has the most working experience in the organization?
        Optional<Employee> seniorMostEmployeeWrapper = employeeList.stream()
                .collect(Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining)));
        //System.out.println(seniorMostEmployeeWrapper);

        //How many male and female employees are there in the sales and marketing team?
        Map<String, Long> countMaleFemaleEmployeesInSalesMarketing = employeeList.stream()
                .filter(employee -> employee.getDepartment() == "Sales And Marketing")
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        //System.out.println(countMaleFemaleEmployeesInSalesMarketing);

        //What is the average salary of male and female employees?
        Map<String, Double> avgSalaryOfMaleAndFemaleEmployees = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        //System.out.println(avgSalaryOfMaleAndFemaleEmployees);

        //List down the names of all employees in each department?
        Map<String, List<Employee>> employeeListByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        //System.out.println(employeeListByDepartment);

        //What is the average salary and total salary of the whole organization?
        DoubleSummaryStatistics collect = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        //System.out.println("Average salary: " + collect.getAverage() + " : " + "Total salary: " + collect.getSum());

        //List<Integer> integers = Arrays.asList(12, 23, 4, 6, 7, 2, 8);

        IntStream.range(0, intList.size())
                .filter(n -> n % 2 != 0)
                .forEach(n -> System.out.print(intList.get(n) * 2 + " "));

        // Map<String, Double> employeeMapIncrementedSalaryByDepartment = employeeList.stream().filter(employee -> employee.getDepartment() == "Product Development");


    }


}