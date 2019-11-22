package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.ArrayList;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator func;

    public SortDecorator(SmartArray smartArray, MyComparator func) {
        super(smartArray);
        this.func = func;
    }

    @Override
    public Object[] toArray() {
        return Arrays.stream(smartArray.toArray()).sorted(func).toArray();
    }

    @Override
    public String operationDescription() {
        if (smartArray.operationDescription().equals("Nothing")) {
            return "Sorting";
        } else {
            return smartArray.operationDescription() + ", sorting";
        }
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
