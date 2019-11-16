package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    private MyPredicate func;

    public FilterDecorator(SmartArray smartArray, MyPredicate func) {
        super(smartArray);
        this.func = func;
    }

    @Override
    public Object[] toArray() {
        ArrayList<Object> result = new ArrayList<>();
        for (int i = 0; i < smartArray.size(); i++) {
            if (func.test(smartArray.toArray()[i])) {
                result.add(smartArray.toArray()[i]);
            }
        }
        return result.toArray();
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
        int result = 0;
        for (int i = 0; i < smartArray.size(); i++) {
            if (func.test(smartArray.toArray()[i])) {
                result++;
            }
        }
        return result;
    }
}
