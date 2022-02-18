package com.trees.exercises.QueueRemovals;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here

    class OriginalPosition {
        int val;
        int position;
        OriginalPosition(int val, int position) {
            this.val = val;
            this.position = position;
        }
    }

    int[] findPositions(int[] arr, int x) {
        // Write your code here

        int counter = x;
        Queue<OriginalPosition> queue = new LinkedList<>();

        for(int i = 0; i < arr.length; i++) {
            queue.offer(new OriginalPosition(arr[i], i + 1));
        }

        while(counter > 0) {
            OriginalPosition max = null;
            int passed = 0;

            while(passed < x && !queue.isEmpty()) {
                OriginalPosition originalPosition = queue.poll();
                if(originalPosition.val > max.val) {
                    max = originalPosition;
                }
                passed++;
            }

            i = 0;
            passed = 0;
            set.add(maxIndex + 1);

            while(i < arr.length && passed < x - 1) {
                if(!set.contains(i + 1)) {
                    arr[i] = arr[i] > 0 ? arr[i] - 1 : 0;
                    passed++;
                }
                i++;
            }

            System.out.println();
            System.out.println();
            System.out.println("Max: " + max);
            System.out.println("Max Index: " + maxIndex);
            System.out.println("Set: " + set);
            Arrays.stream(arr).forEach(j -> System.out.print(j + " "));

            counter--;
        }

        int[] result = new int[set.size()];
        int i = 0;
        for(int r: set) {
            result[i] = r;
            i++;
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
