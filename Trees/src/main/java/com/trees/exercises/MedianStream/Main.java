package com.trees.exercises.MedianStream;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here


    int[] findMedian(int[] arr) {
        // Write your code here

        // Smallest queue puts largest at front
        // Largest queue puts smallest at front
        Queue<Integer> smallestQueue = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> largestQueue = new PriorityQueue<>((a, b) -> a - b);

        int[] result = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {

            int next = arr[i];

            if(smallestQueue.isEmpty()) {
                smallestQueue.offer(next);
                // Can we move this out?
                result[i] = next;
            } else {

                if(next <= smallestQueue.peek()) {
                    // Can simplify this logic
                    if(smallestQueue.size() < largestQueue.size() + 1) {
                        smallestQueue.offer(next);
                    } else {
                        largestQueue.offer(smallestQueue.poll());
                        smallestQueue.offer(next);
                    }
                } else {

                    if(smallestQueue.size() < largestQueue.size() + 1) {
                        if(next < largestQueue.peek()) {
                            smallestQueue.offer(next);
                        } else {
                            smallestQueue.offer(largestQueue.poll());
                            largestQueue.offer(next);
                        }
                    } else {
                        largestQueue.offer(next);
                    }

                }

                if(i % 2 == 0) {
                    result[i] = smallestQueue.peek();
                } else {
                    result[i] = (smallestQueue.peek() + largestQueue.peek()) / 2;
                }
            }
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
        int[] arr_1 = {5, 15, 1, 3};
        int[] expected_1 = {5, 10, 5, 4};
        int[] output_1 = findMedian(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {2, 4, 7, 1, 5, 3};
        int[] expected_2 = {2, 3, 4, 3, 4, 3};
        int[] output_2 = findMedian(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new Main().run();
    }
}