package ua.edu.ucu;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        //sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        //sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        //sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
        sa = new MapDecorator(
                new SortDecorator(
                        new FilterDecorator(sa, pr),
                        cmp),
                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        MyPredicate prYear = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getYear() == 2;
            }
        };

        MyPredicate prGPA = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getGPA() >= 4.0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Student) o1).getSurname()
                        .compareTo(((Student) o2).getSurname());
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Student) t).getSurname()
                        + " " + ((Student) t).getName();
            }
        };

        SmartArray studentSmartArray = new BaseArray(students);
        studentSmartArray = new DistinctDecorator(studentSmartArray);
        studentSmartArray = new FilterDecorator(studentSmartArray, prYear);
        studentSmartArray = new FilterDecorator(studentSmartArray, prGPA);
        studentSmartArray = new SortDecorator(studentSmartArray, cmp);
        studentSmartArray = new MapDecorator(studentSmartArray, func);
        // Hint: to convert Object[] to String[] - use the following code
        Object[] result = studentSmartArray.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }

    public static void main(String[] args) {
        BaseArray a = new BaseArray(new Integer[]{1,2,3,4,5});
        MapDecorator b = new MapDecorator(a,x->(Integer)x*(Integer)x);
        System.out.println(Arrays.toString(a.toArray()));
        System.out.println(Arrays.toString(b.toArray()));

        a.setValue(0); // що це працювало додайте метод setValue(int index){array[index] = 0};
        System.out.println(Arrays.toString(a.toArray()));
        System.out.println(Arrays.toString(b.toArray()));

    }
}
