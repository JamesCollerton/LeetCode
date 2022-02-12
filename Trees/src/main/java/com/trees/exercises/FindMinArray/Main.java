package com.trees.exercises.FindMinArray;

import java.util.*;
// Add any extra import statements you may need here


class Main {

    int[] findMinArray(int[] arr, int k) {
        // Write your code here

        int remaining = k;
        int smallestStart = 0;

        while(remaining > 0) {

            // Find minimum furthest away
            int minFurthAway = findMinimumFurthestAway(smallestStart, remaining, arr);

            // If it's not in the right place move as far ahead as possible
            if(minFurthAway != smallestStart) {
                int i = minFurthAway;
                while(i != smallestStart && remaining > 0) {
                    swap(arr, i);
                    i--;
                    remaining--;
                }
            }

            // Always want to increment where we've sorted to
            smallestStart++;
        }

        return arr;
    }

    private void swap(int[] arr, int i) {
        int temp = arr[i];
        arr[i] = arr[i - 1];
        arr[i - 1] = temp;
    }

    private int findMinimumFurthestAway(int start, int remaining, int[] arr) {

        System.out.println(start);
        System.out.println(remaining);

        int minValue = Integer.MAX_VALUE;
        int index = -1;

        for(int i = start; i < Math.min(arr.length, start + remaining + 1); i++) {
            if(arr[i] < minValue || arr[i] == minValue && i > index) {
                minValue = arr[i];
                index = i;
            }
        }

        return index;
    }












    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int n_1 = 3, k_1 = 2;
        int[] arr_1 = {5, 3, 1};
        int[] expected_1 = {1, 5, 3};
        int[] output_1 = findMinArray(arr_1,k_1);
        check(expected_1, output_1);

        int n_2 = 5, k_2 = 3;
        int[] arr_2 = {8, 9, 11, 2, 1};
        int[] expected_2 = {2, 8, 9, 11, 1};
        int[] output_2 = findMinArray(arr_2,k_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new Main().run();
    }
}
