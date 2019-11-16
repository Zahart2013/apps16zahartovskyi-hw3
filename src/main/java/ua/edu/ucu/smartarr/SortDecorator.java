package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.ArrayList;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator func;

    public SortDecorator(SmartArray smartArray, MyComparator func) {
        super(smartArray);
        this.func = func;
    }

    @Override
    public Object[] toArray() {
        ArrayList<Object> result = new ArrayList<>();
        for (int i = 0; i < smartArray.size(); i++) {
            boolean added = false;
            for (int j = 0; j < result.size(); j++) {
                if (func.compare(smartArray.toArray()[i], result.get(j)) < 0) {
                    result.add(j, smartArray.toArray()[i]);
                    added = true;
                    break;
                }
            }
            if (!added) {
                result.add(smartArray.toArray()[i]);
            }
        }
        return result.toArray();
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
        return smartArray.size();
    }
}
