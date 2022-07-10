package com.java.staticvsdefault;

import java.util.List;

public class MultiplyImpl implements Multiply {
    @Override
    public int multiply(List<Integer> list) {
        return list.stream().reduce(1, (x, y) -> x * y);
    }
}
