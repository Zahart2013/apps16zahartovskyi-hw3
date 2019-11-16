package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] baseArray;

    public BaseArray(Object[] arr) {
        baseArray = Arrays.copyOf(arr, arr.length);
    }

    @Override
    public Object[] toArray() {
        return baseArray;
    }

    @Override
    public String operationDescription() {
        return "Nothing";
    }

    @Override
    public int size() {
        return baseArray.length;
    }
}
