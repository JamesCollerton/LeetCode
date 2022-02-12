package com.trees.exercises.MaxAwkwardness;

import java.util.*;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here


    int minOverallAwkwardness(int[] arr) {
        // Write your code here

        Arrays.sort(arr);

        int first = arr.length - 1;
        int left = arr.length - 2;
        int right = arr.length - 3;

        int leftMax = absoluteDifference(arr[first], arr[left]);
        int rightMax = absoluteDifference(arr[first], arr[right]);
        int maxAwkwardness = max(leftMax, rightMax);

        while(left > 2) {
            maxAwkwardness = max(maxAwkwardness, absoluteDifference(arr[left], arr[left - 2]));
            left -= 2;
        }
        while(right > 1) {
            maxAwkwardness = max(maxAwkwardness, absoluteDifference(arr[right], arr[right - 2]));
            right -= 2;
        }

        if(arr.length % 2 == 0) {
            maxAwkwardness = max(maxAwkwardness, absoluteDifference(arr[left], arr[right]));
        } else {
            maxAwkwardness = max(maxAwkwardness, absoluteDifference(arr[left], arr[0]));
            maxAwkwardness = max(maxAwkwardness, absoluteDifference(arr[right], arr[0]));
        }

        return maxAwkwardness;

    }

    private int absoluteDifference(int a, int b) {
        return (a - b > 0) ? a - b : -(a - b);
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
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
        int[] arr_1 = {5, 10, 6, 8};
        int expected_1 = 4;
        int output_1 = minOverallAwkwardness(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {1, 2, 5, 3, 7};
        int expected_2 = 4;
        int output_2 = minOverallAwkwardness(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new Main().run();
    }
}