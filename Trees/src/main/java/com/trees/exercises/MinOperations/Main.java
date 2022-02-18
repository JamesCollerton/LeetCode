package com.trees.exercises.MinOperations;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here


    int minOperations(int[] arr) {
        // Write your code here

        Queue<int[]> queue = new LinkedList<>();
        Set<int[]> seen = new HashSet<>();

        int[] target = arr.clone();
        int level = 0;
        Arrays.sort(target);

        queue.offer(arr);

        while(!queue.isEmpty()) {

            int size = queue.size();

            while(size > 0) {

                int[] permutation = queue.poll();

                if(arraysEqual(target, permutation)) {
                    return level;
                }

                for(int i = 0; i < permutation.length; i++) {
                    for(int j = i + 1; j < permutation.length; j++) {
                        int[] newPermutation = permutation.clone();
                        reverseArr(newPermutation, i, j);
                        if(!seen.contains(newPermutation)) {
                            queue.offer(newPermutation);
                            seen.add(newPermutation);
                        }
                    }
                }

                size--;
            }

            level++;
        }

        return -1;
    }

    private boolean arraysEqual(int[] a, int[] b) {
        if(a.length == b.length) {
            for(int i = 0; i < a.length; i++) {
                if(a[i] != b[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private void reverseArr(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
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

        int n_1 = 5;
        int[] arr_1 = {1, 2, 5, 4, 3};
        int expected_1 = 1;
        int output_1 = minOperations(arr_1);
        check(expected_1, output_1);

        int n_2 = 3;
        int[] arr_2 = {3, 1, 2};
        int expected_2 = 2;
        int output_2 = minOperations(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new Main().run();
    }
}