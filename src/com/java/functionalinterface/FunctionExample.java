package com.java.functionalinterface;

import java.util.function.Function;

public class FunctionExample {
  static Function<String, String> function = (name) -> name.toUpperCase();
  static Function<String, String> concat = (name) -> name.concat("default");

  public static void main(String[] args) {
    System.out.println(function.apply("java8"));
    System.out.println(function.andThen(concat).apply("java8"));
    System.out.println(function.compose(concat).apply("java8"));
  }
}
