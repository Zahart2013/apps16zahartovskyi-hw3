package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        return Arrays.stream(smartArray.toArray()).distinct().toArray();
    }

    @Override
    public String operationDescription() {
        if (smartArray.operationDescription().equals("Nothing")) {
            return "Distinct";
        } else {
            return smartArray.operationDescription() + ", distinct";
        }
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
