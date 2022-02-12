package com.trees.exercises.FindMinArray;

import java.util.*;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here
    private final int INDEX = 0;
    private final int VALUE = 1;

    int[] findMinArray(int[] arr, int k) {
        // Write your code here

        // This orders items by value, then by
        // index so lowest numbers further down
        // the array come first.
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            int valueDifference = a[VALUE] - b[VALUE];
            if(valueDifference != 0) {
                return valueDifference
            }
            return b[INDEX] - a[INDEX];
        });

        // We need to populate the queue

        // Where we want to move our item to and
        // how many swaps we have left
        int smallestStart = 0;
        int remaining = k;

        // While we've got places to move to
        while(!queue.isEmpty() && k > 0) {

            // Get the furthest away item with the smallest value
            int[] smallestValue = queue.poll();
            int value = smallestValue[VALUE];
            int index = smallestValue[INDEX];

            // If this isn't already in the right place
            if(index != smallestStart) {

                int placesToShuffle;
                if(index - smallestStart <= remaining) {
                    placesToShuffle = index - smallestStart;
                } else {
                    placesToShuffle = remaining;
                }

                int i = index;

                while(placesToShuffle > 0) {
                    arr[i] = arr[i - 1]
                    i--;
                    placesToShuffle--;
                }

                arr[i] = value;

                remaining -= placesToShuffle;
            }
            smallestStart++;
        }

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
