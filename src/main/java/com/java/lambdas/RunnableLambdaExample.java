package com.java.lambdas;

public class RunnableLambdaExample {
  public static void main(String[] args) {
    /** Prior Java 8 */
    Runnable runnable = new Runnable() {
          @Override
          public void run() {
            System.out.println("Inside runnable 1");
          }
        };
    new Thread(runnable).start();

    /** Java 8 () -> {} */
    Runnable runnableLambda = () -> {
          System.out.println("Inside runnable 2");
        };
    new Thread(runnableLambda).start();
    new Thread(() -> System.out.println("Inside runnable 3")).start();
  }
}
