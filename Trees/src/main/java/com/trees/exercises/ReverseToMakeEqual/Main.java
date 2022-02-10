package com.trees.exercises.ReverseToMakeEqual;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here


    boolean areTheyEqual(int[] array_a, int[] array_b) {
        // Write your code here
        Map<Integer, Integer> arrayAIntCountMap = new HashMap<>();
        Map<Integer, Integer> arrayBIntCountMap = new HashMap<>();

        for(int i = 0; i < array_a.length; i++) {
            arrayAIntCountMap.put(array_a[i], arrayAIntCountMap.getOrDefault(array_a[i], 0) + 1);
        }
        for(int i = 0; i < array_b.length; i++) {
            arrayBIntCountMap.put(array_b[i], arrayBIntCountMap.getOrDefault(array_b[i], 0) + 1);
        }

        if(!arrayAIntCountMap.keySet().equals(arrayBIntCountMap.keySet())) {

            return false;
        }

        for(Integer mapAKey: arrayAIntCountMap.keySet()) {
            if(!arrayAIntCountMap.get(mapAKey).equals(arrayBIntCountMap.get(mapAKey))) {
                return false;
            }
        }

        return true;
    }











    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }

    public void run() {
        int[] array_a_1 = {1, 2, 3, 4};
        int[] array_b_1 = {1, 4, 3, 2};
        boolean expected_1 = true;
        boolean output_1 = areTheyEqual(array_a_1, array_b_1);
        check(expected_1, output_1);

        int[] array_a_2 = {1, 2, 3, 4};
        int[] array_b_2 = {1, 4, 3, 3};
        boolean expected_2 = false;
        boolean output_2 = areTheyEqual(array_a_2, array_b_2);
        check(expected_2, output_2);
        // Add your own test cases here

    }

    public static void main(String[] args) {
        new Main().run();
    }
}
