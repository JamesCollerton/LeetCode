package com.trees.exercises.MatchingPairs;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here


    int matchingPairs(String s, String t) {
        // Write your code here

        Map<Character, Integer> gotCharacterToIndexMap = new HashMap<>();
        int matchedCounter = 0;
        int maxSwapIncrement = 0;

        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(sChar == tChar) {
                matchedCounter++;
            } else {
                if(gotCharacterToIndexMap.containsKey(tChar)) {
                    char characterWeHave = sChar;
                    char characterWeNeed = tChar;
                    int characterWeNeedIndex = gotCharacterToIndexMap.get(characterWeNeed);
                    char characterWeNeedAtNeededIndex = t.charAt(characterWeNeedIndex);
                    if(characterWeNeedAtNeededIndex == characterWeHave) {
                        maxSwapIncrement = 2;
                    } else {
                        maxSwapIncrement = maxSwapIncrement > 1 ? maxSwapIncrement : 1;
                    }
                }
                gotCharacterToIndexMap.put(sChar, i);
            }
        }

        if(matchedCounter == s.length()) {
            return matchedCounter - 2;
        } else {
            return matchedCounter + maxSwapIncrement;
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
        String s_1 = "abcde";
        String t_1 = "adcbe";
        int expected_1 = 5;
        int output_1 = matchingPairs(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "abcd";
        String t_2 = "abcd";
        int expected_2 = 2;
        int output_2 = matchingPairs(s_2, t_2);
        check(expected_2, output_2);

        String s_3 = "xyz";
        String t_3 = "abc";
        int expected_3 = 0;
        int output_3 = matchingPairs(s_3, t_3);
        check(expected_3, output_3);

        String s_4 = "abcdef";
        String t_4 = "adcbex";
        int expected_4 = 5;
        int output_4 = matchingPairs(s_4, t_4);
        check(expected_4, output_4);
    }
    public static void main(String[] args) {
        new Main().run();
    }
}