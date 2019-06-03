package uk.co.pantasoft.java8;

import java.util.Arrays;
import java.util.List;

public class ReduceToSum {

    public static void main(String[] args) {

        reduceListAndArrayIntoSum();
        reduceListAndArrayIntoString();
    }

    private static void reduceListAndArrayIntoSum() {

        //Reduce Array to sum.
        int[] array = {1, 2, 3, 4, 5};
        int sum = Arrays.stream(array).reduce(0, (a, b) -> a + b);
        System.out.println("Sum of Array: " + sum);

        //Reduce List to sum.
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        sum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum of List: " + sum);

        //Output:
        //- Sum of Array: 15
        //- Sum of List: 15
    }

    private static void reduceListAndArrayIntoString() {

        //Reduce Array to String.
        String[] array = {"Massimo", "Ettore"};
        Arrays.stream(array).reduce((x, y) -> x +"," + y)
                .ifPresent(s -> System.out.println("Array to String: "+ s));

        //Reduce List to String.
        List<String> list = Arrays.asList("Massimo", "Ettore");
        list.stream().reduce((x, y) -> x +"," + y)
                .ifPresent(s -> System.out.println("List to String: "+ s));
    }
}
