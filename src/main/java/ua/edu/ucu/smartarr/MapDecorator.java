package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.ArrayList;
import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction func;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.func = func;
    }

    @Override
    public Object[] toArray() {
        return Arrays.stream(smartArray.toArray()).map(func::apply).toArray();
    }

    @Override
    public String operationDescription() {
        if (smartArray.operationDescription().equals("Nothing")) {
            return "Mapping";
        } else {
            return smartArray.operationDescription() + ", mapping";
        }
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
