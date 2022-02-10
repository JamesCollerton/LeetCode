package com.trees.exercises.PassingYearbooks;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here


    int[] findSignatureCounts(int[] arr) {
        // Write your code here

        int[] result = new int[arr.length];
        Set<Integer> seen = new HashSet<>();

        for(int i = 0; i < result.length; i++) {
            result[i] = 1;
        }

        int pointer = arr.length - 1;

        boolean found = false;

        // Find first value not in the space it should be
        while(seen.size() != arr.length && !found) {
            if(arr[pointer] == pointer + 1) {
                seen.add(pointer);
                if(pointer != 0) {
                    pointer--;
                } else {
                    pointer = arr.length - 1;
                }
            } else {
                found = true;
            }
        }

        int pointerValue = arr[pointer];

        while(seen.size() != arr.length) {

            int newPointer = pointer == 0 ? arr.length - 1 : pointer - 1;

            System.out.println(newPointer);
            found = false;

            while(seen.size() != arr.length && !found) {
                if(arr[newPointer] == newPointer + 1) {
                    seen.add(newPointer);
                    if(newPointer != 0) {
                        newPointer--;
                    } else {
                        newPointer = arr.length - 1;
                    }
                } else {
                    found = true;
                }
            }

            if(seen.size() != arr.length) {
                result[pointer]++;
                int temp = pointerValue;
                pointerValue = arr[newPointer];
                arr[newPointer] = temp;
            }

            pointer = newPointer;
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
        int[] arr_1 = {2, 1};
        int[] expected_1 = {2, 2};
        int[] output_1 = findSignatureCounts(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {1, 2};
        int[] expected_2 = {1, 1};
        int[] output_2 = findSignatureCounts(arr_2);
        check(expected_2, output_2);

        int[] arr_3 = {1, 2, 3};
        int[] expected_3 = {1, 1, 1};
        int[] output_3 = findSignatureCounts(arr_3);
        check(expected_3, output_3);

        // Add your own test cases here

    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}