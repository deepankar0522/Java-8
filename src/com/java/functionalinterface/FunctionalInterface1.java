package com.java.functionalinterface;

public class FunctionalInterface1 {


    public static void main(String[] args) {
        String result = performConcat("Hello");
        System.out.println("Result: "+result);
    }

    private static String performConcat(String str) {
        return FunctionExample.function.apply(str);
    }
}
