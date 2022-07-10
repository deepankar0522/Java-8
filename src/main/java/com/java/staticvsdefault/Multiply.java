package com.java.staticvsdefault;

import java.util.List;

public interface Multiply {
    public int multiply(List<Integer> list);

    default int size (List<Integer> list){
        return list.size();
    }

    static boolean isEmpty(List<Integer> integerList){
        return integerList==null && integerList.size()>0;
    }
}
