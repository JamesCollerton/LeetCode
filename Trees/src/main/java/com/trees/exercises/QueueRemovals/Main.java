package com.trees.exercises.QueueRemovals;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
// Add any extra import statements you may need here


import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here
    class OriginalPosition {
        int val;
        int index;
        OriginalPosition(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    int[] findPositions(int[] arr, int x) {
        // Write your code here

        int iterations = 0;
        int[] result = new int[x];

        Queue<OriginalPosition> queue = new LinkedList<>();

        for(int i = 0; i < arr.length; i++) {
            queue.offer(new OriginalPosition(arr[i], i + 1));
        }

        while(iterations < x) {

            Queue<OriginalPosition> tempQueue = new LinkedList<>();

            int counter = x;
            OriginalPosition max = null;

            while(counter > 0 && !queue.isEmpty()) {
                OriginalPosition originalPosition = queue.poll();
                if(max == null || originalPosition.val > max.val) {
                    max = originalPosition;
                }
                tempQueue.offer(originalPosition);
                counter--;
            }

            while(!tempQueue.isEmpty()) {
                OriginalPosition originalPosition = tempQueue.poll();
                if(!max.equals(originalPosition)) {
                    if(originalPosition.val != 0) {
                        originalPosition.val = originalPosition.val - 1;
                    }
                    queue.offer(originalPosition);
                } else {
                    result[iterations] = originalPosition.index;
                }
            }

            iterations++;
        }

        return result;
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
        int n_1 = 6;
        int x_1 = 5;
        int[] arr_1 = {1, 2, 2, 3, 4, 5};
        int[] expected_1 = {5, 6, 4, 1, 2 };
        int[] output_1 = findPositions(arr_1, x_1);
        check(expected_1, output_1);

        int n_2 = 13;
        int x_2 = 4;
        int[] arr_2 = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
        int[] expected_2 = {2, 5, 10, 13};
        int[] output_2 = findPositions(arr_2, x_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new Main().run();
    }
}
