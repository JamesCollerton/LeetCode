package com.trees.exercises.ReverseToMakeEqual;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here


    boolean areTheyEqual(int[] array_a, int[] array_b) {

        Map<Integer, Integer> aIntToCountMap = new HashMap<>();
        Map<Integer, Integer> bIntToCountMap = new HashMap<>();

        for(int num: array_a) {
            aIntToCountMap.put(num, aIntToCountMap.getOrDefault(num, 0) + 1);
        }

        for(int num: array_b) {
            bIntToCountMap.put(num, bIntToCountMap.getOrDefault(num, 0) + 1);
        }

        for(int aKey: aIntToCountMap.keySet()) {
            if(!bIntToCountMap.containsKey(aKey) || !(bIntToCountMap.get(aKey).equals(aIntToCountMap.get(aKey)))) {
                return false;
            }
        }

        for(int bKey: bIntToCountMap.keySet()) {
            if(!aIntToCountMap.containsKey(bKey) || !(bIntToCountMap.get(bKey).equals(aIntToCountMap.get(bKey)))) {
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
