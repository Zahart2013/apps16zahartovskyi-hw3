package ua.edu.ucu.smartarr;

import java.util.ArrayList;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        ArrayList<Object> result = new ArrayList<>();
        for (int i = 0; i < smartArray.size(); i++) {
            int j = i + 1;
            while (j < smartArray.size() && !(result.contains(smartArray.toArray()[i]))) {
                if (!(smartArray.toArray()[i].equals(smartArray.toArray()[j]))) {
                    result.add(smartArray.toArray()[i]);
                }
                j++;
            }
        }
        return result.toArray();
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
        int result = 0;
        ArrayList<Object> noCopies = new ArrayList<>();
        for (int i = 0; i < smartArray.size(); i++) {
            int j = i + 1;
            while (j < smartArray.size() && !(noCopies.contains(smartArray.toArray()[i]))) {
                if (!(smartArray.toArray()[i].equals(smartArray.toArray()[j]))) {
                    noCopies.add(smartArray.toArray()[i]);
                    result++;
                }
                j++;
            }
        }
        return result;
    }
}
