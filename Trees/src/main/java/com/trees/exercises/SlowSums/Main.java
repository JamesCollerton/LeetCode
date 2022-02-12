package com.trees.exercises.SlowSums;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here

    // [1, 2, 3, 4] 7
    // [1, 2, 7] 9
    // [1, 9] 10
    // [10]

    // [1, 2, 3, 4] 5
    // [1, 5, 4] 6
    // [6, 4] 10
    // [10]

    int getTotalTime(int[] arr) {
        // Write your code here
        if(arr.length < 2) {
            return 0;
        }

        Arrays.sort(arr);

        int pointer = arr.length - 1;
        int penalty = 0;

        while(pointer != 0) {
            int lastValue = arr[pointer];
            int secondLastValue = arr[pointer -1];
            arr[pointer - 1] = lastValue + secondLastValue;
            penalty += lastValue + secondLastValue;
            pointer--;
        }

        return penalty;
    }












    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }
    public void run() {
        int[] arr_1 = {4, 2, 1, 3};
        int expected_1 = 26;
        int output_1 = getTotalTime(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {2, 3, 9, 8, 4};
        int expected_2 = 88;
        int output_2 = getTotalTime(arr_2);
        check(expected_2, output_2);

        int[] arr_3 = {7, 8, 1, 7, 8, 7};
        int expected_3 = 144;
        int output_3 = getTotalTime(arr_3);
        check(expected_3, output_3);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new Main().run();
    }
}