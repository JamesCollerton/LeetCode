package com.trees.exercises.EncryptedWords;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here


    String findEncryptedWord(String s) {
        // Write your code here
        return encryptString(0, s.length() - 1, s);
    }

    String encryptString(int start, int end, String s) {
        if(s == null || "".equals(s) || start > end) {
            return "";
        }

        int mid = start + (end - start) / 2;

        return Character.toString(s.charAt(mid)) + encryptString(start, mid - 1, s) + encryptString(mid + 1, end, s);

    }











    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String s_1 = "abc";
        String expected_1 = "bac";
        String output_1 = findEncryptedWord(s_1);
        check(expected_1, output_1);

        String s_2 = "abcd";
        String expected_2 = "bacd";
        String output_2 = findEncryptedWord(s_2);
        check(expected_2, output_2);

        // Add your own test cases here
        String s_3 = "abcxcba";
        String expected_3 = "xbacbca";
        String output_3 = findEncryptedWord(s_3);
        check(expected_3, output_3);

        String s_4 = "facebook";
        String expected_4 = "eafcobok";
        String output_4 = findEncryptedWord(s_4);
        check(expected_4, output_4);

    }

    public static void main(String[] args) {
        new Main().run();
    }
}
