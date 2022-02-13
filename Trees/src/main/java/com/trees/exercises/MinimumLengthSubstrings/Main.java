package com.trees.exercises.MinimumLengthSubstrings;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here


    int minLengthSubstring(String s, String t) {
        // Write your code here

        // Create a map of characters to all indexes where they appear
        Map<Character, List<Integer>> charToIndexesMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!charToIndexesMap.containsKey(c)) {
                charToIndexesMap.put(c, new ArrayList<>());
            }
            charToIndexesMap.get(c).add(i);
        }

        // Calculate the minimum and maximum indexes we need to swap at
        // to include the t string
        int minIndex = Integer.MAX_VALUE;
        int maxIndex = Integer.MIN_VALUE;

        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            if(!charToIndexesMap.containsKey(c)) {
                return -1;
            }

            // Get all the indexes where this character appears
            List<Integer> characterIndexes = charToIndexesMap.get(c);

            // If there's only one then we can use it and remove it
            // as there's no other choice.
            if(characterIndexes.size() == 1) {
                minIndex = min(minIndex, characterIndexes.get(0));
                maxIndex = max(maxIndex, characterIndexes.get(0));
                charToIndexesMap.remove(c);
            } else {

                // Need to pick index between min and max, or the one closest to
                // either.
                int spaceToRemove = -1;
                int overallMinDistanceFromSubstring = Integer.MAX_VALUE;

                for(int j = 0; j < characterIndexes.size(); j++) {
                    int index = characterIndexes.get(j);

                    // If we can find an index already in our substring
                    // then we should use that
                    if(index >= minIndex && index <= maxIndex) {
                        overallMinDistanceFromSubstring = 0;
                        spaceToRemove = j;
                    } else {
                        int distanceFromMin = minIndex == Integer.MAX_VALUE ? 0 : abs(minIndex - index);
                        int distanceFromMax = maxIndex == Integer.MIN_VALUE ? 0 : abs(maxIndex - index);
                        int minDistanceFromSubstring = min(distanceFromMin, distanceFromMax);
//                        System.out.println();
//                        System.out.println("Index: " + index);
//                        System.out.println("Distance from min: " + distanceFromMin);
//                        System.out.println("Distance from max: " + distanceFromMax);
//                        System.out.println("Min distance from substring: " + minDistanceFromSubstring);
                        if(minDistanceFromSubstring < overallMinDistanceFromSubstring) {
                            overallMinDistanceFromSubstring = minDistanceFromSubstring;
                            spaceToRemove = j;
                        }
                    }
                }

                minIndex = min(minIndex, characterIndexes.get(spaceToRemove));
                maxIndex = max(maxIndex, characterIndexes.get(spaceToRemove));
                characterIndexes.remove(spaceToRemove);
            }

        }

        return (maxIndex - minIndex) + 1;
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private int abs(int a) {
        return a < 0 ? -a : a;
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
    public void run() throws IOException {
        String s_1 = "dcbefebce";
        String t_1 = "fd";
        int expected_1 = 5;
        int output_1 = minLengthSubstring(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t_2 = "cbccfafebccdccebdd";
        int expected_2 = -1;
        int output_2 = minLengthSubstring(s_2, t_2);
        check(expected_2, output_2);

        // Add your own test cases here
        String s_3 = "ddcbefebce";
        String t_3 = "fd";
        int expected_3 = 5;
        int output_3 = minLengthSubstring(s_3, t_3);
        check(expected_3, output_3);

        String s_4 = "ddcbefebfe";
        String t_4 = "fd";
        int expected_4 = 5;
        int output_4 = minLengthSubstring(s_4, t_4);
        check(expected_4, output_4);

    }
    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
