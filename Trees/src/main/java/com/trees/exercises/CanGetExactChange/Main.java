package com.trees.exercises.CanGetExactChange;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here


    Map<Integer, Boolean> memoisation = new HashMap<>();

    boolean canGetExactChange(int targetMoney, int[] denominations) {
        // Write your code here
        System.out.println();
        memoisation = new HashMap<>();
        return findChange(0, targetMoney, denominations);
    }

    boolean findChange(int runningTotal, int targetMoney, int[] denominations) {

        if(memoisation.containsKey(runningTotal)) {
            return memoisation.get(runningTotal);
        }

        if(runningTotal == targetMoney) {
            return true;
        } else if(runningTotal > targetMoney) {
            return false;
        }

        boolean result = false;
        for(int denomination: denominations) {
            if(!result) {
                result = result || findChange(runningTotal + denomination, targetMoney, denominations);
            }
        }

        System.out.println("Running total " + runningTotal + " " + result);
        memoisation.put(runningTotal, result);

        return result;
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
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        int target_1 = 94;
        int arr_1[] = {5, 10, 25, 100, 200};
        boolean expected_1 = false;
        boolean output_1 = canGetExactChange(target_1, arr_1);
        check(expected_1, output_1);

        int target_2 = 75;
        int arr_2[] = {4, 17, 29};
        boolean expected_2 = true;
        boolean output_2 = canGetExactChange(target_2, arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new Main().run();
    }
}
