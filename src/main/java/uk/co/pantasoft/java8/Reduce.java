package uk.co.pantasoft.java8;

import java.util.Arrays;
import java.util.List;

public class Reduce {

    public static void main(String[] args) {

        reduceListAndArrayIntoSum();
        reduceListAndArrayIntoString();
        reduceWithIdentityAndAccumulator();
        reduceWithIdentityAndAccumulatorAndCombiner();
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
        Arrays.stream(array).reduce((x, y) -> x + "," + y)
                .ifPresent(s -> System.out.println("Array to String: " + s));

        //Reduce List to String.
        List<String> list = Arrays.asList("Massimo", "Ettore");
        list.stream().reduce((x, y) -> x + "," + y)
                .ifPresent(s -> System.out.println("List to String: " + s));

        //Output:
        //- Array to String: Massimo,Ettore
        //- List to String: Massimo,Ettore
    }

    private static void reduceWithIdentityAndAccumulator() {

        int[] array = {1, 2, 3};
        //Set start value. Result will be start value + sum of array.
        int startValue = 10;
        int sum;

        sum = Arrays.stream(array)
                .reduce(startValue, (x, y) -> x + y);
        System.out.println("sum = " + sum);

        sum = Arrays.stream(array)
                .reduce(startValue, Integer::sum);
        System.out.println("sum = " + sum);

        sum = Arrays.stream(array)
                .reduce(startValue, StatisticsUtility::addIntData);
        System.out.println("sum = " + sum);

        //Output:
        //- sum = 16
        //- sum = 16
        //- sum = 16
    }

    private static class StatisticsUtility {
        private static int addIntData(int num1, int num2) {
            return num1 + num2;
        }
    }

    private static void reduceWithIdentityAndAccumulatorAndCombiner() {

        List<Integer> list2 = Arrays.asList(1, 2, 3);
        int res = list2.parallelStream().reduce(1, (a, b) -> a + b, (x, y) -> x + y);
        System.out.println("Result = " + res);

        //Output:
        //- Result = 9
    }
}
