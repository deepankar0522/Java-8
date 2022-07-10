package com.java.lambdas;

import java.util.Comparator;

public class ComparatorLambdaExample {
  public static void main(String[] args) {
    /** Prior java 8 */
    Comparator<Integer> comparator = new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
          }
        };
    System.out.println("result: " + comparator.compare(3, 2));

    /** Java 8 */
    Comparator<Integer> comparatorLambda = (a, b) -> a.compareTo(b);
    System.out.println("ResultLambda: " + comparator.compare(3, 2));
  }
}
