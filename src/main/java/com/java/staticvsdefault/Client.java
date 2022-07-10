package com.java.staticvsdefault;

import java.util.Arrays;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        Multiply multiply = new MultiplyImpl();
        List<Integer> integerList = Arrays.asList(1,3,5);
        System.out.println(multiply.multiply(integerList));
        System.out.println(multiply.size(integerList));
        System.out.println(Multiply.isEmpty(integerList));
    }
}
