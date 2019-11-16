package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.ArrayList;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction func;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.func = func;
    }

    @Override
    public Object[] toArray() {
        ArrayList<Object> result = new ArrayList<>();
        for (int i = 0; i < smartArray.size(); i++) {
            result.add(func.apply(smartArray.toArray()[i]));
        }
        return result.toArray();
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
        return smartArray.size();
    }
}
