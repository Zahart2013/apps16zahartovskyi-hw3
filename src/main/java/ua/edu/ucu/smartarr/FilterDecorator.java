package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    private MyPredicate func;

    public FilterDecorator(SmartArray smartArray, MyPredicate func) {
        super(smartArray);
        this.func = func;
    }

    @Override
    public Object[] toArray() {
        return Arrays.stream(smartArray.toArray()).filter(func::test).toArray();
    }

    @Override
    public String operationDescription() {
        if (smartArray.operationDescription().equals("Nothing")) {
            return "Filtering";
        } else {
            return smartArray.operationDescription() + ", filtering";
        }
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
