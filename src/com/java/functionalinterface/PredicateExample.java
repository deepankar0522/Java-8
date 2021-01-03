package com.java.functionalinterface;

import java.util.function.Predicate;

public class PredicateExample {
  static Predicate<Integer> p = (integer) -> integer % 2 == 0;
  static Predicate<Integer> p1 = (integer) -> integer % 2 == 0;
  static Predicate<Integer> p2 = (integer) -> integer % 5 == 0;

  public static void predicateAnd() {
    System.out.println("Predicate AND: " + p1.and(p2).test(10));
    System.out.println("Predicate AND: " + p1.and(p2).test(15));
  }

  public static void predicateOr() {
    System.out.println("Predicate OR: " + p1.or(p2).test(10));
    System.out.println("Predicate OR: " + p1.or(p2).test(15));
  }

  public static void predicateNegate() {
    System.out.println("Predicate NEGATE: " + p1.or(p2).negate().test(15));
  }

  public static void main(String[] args) {
    System.out.println(p.test(4));
    predicateAnd();
    predicateOr();
    predicateNegate();
  }
}
