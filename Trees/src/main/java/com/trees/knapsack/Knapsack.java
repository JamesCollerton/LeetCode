package com.trees.knapsack;

import java.util.Arrays;

public class Knapsack {

    public static void main(String[] args) {

        System.out.println(calculateKnapsackSolution(10, new int[]{10, 40, 30, 50}, new int[]{5, 4, 6, 3}));

        int w = 10;
        int n = 4;
        int[] val = {10, 40, 30, 50};
        int[] wt = {5, 4, 6, 3};

        // Populate base cases
        int[][] mat = new int[n + 1][w + 1];
        for (int r = 0; r < w + 1; r++) {
            mat[0][r] = 0;
        }
        for (int c = 0; c < n + 1; c++) {
            mat[c][0] = 0;
        }

        // Main logic
        for (int item = 1; item <= n; item++) {
            for (int capacity = 1; capacity <= w; capacity++) {
                int maxValWithoutCurr = mat[item - 1][capacity]; // This is guaranteed to exist
                int maxValWithCurr = 0; // We initialize this value to 0

                int weightOfCurr = wt[item - 1]; // We use item -1 to account for the extra row at the top
                if (capacity >= weightOfCurr) { // We check if the knapsack can fit the current item
                    maxValWithCurr = val[item - 1]; // If so, maxValWithCurr is at least the value of the current item

                    int remainingCapacity = capacity - weightOfCurr; // remainingCapacity must be at least 0
                    maxValWithCurr += mat[item - 1][remainingCapacity]; // Add the maximum value obtainable with the remaining capacity
                }

                mat[item][capacity] = Math.max(maxValWithoutCurr, maxValWithCurr); // Pick the larger of the two
            }
        }

        System.out.println(mat[n][w]); // Final answer
        System.out.println(Arrays.deepToString(mat)); // Visualization of the table
    }

    private static int calculateKnapsackSolution(int totalWeight, int[] values, int[] weights) {

        int totalNumberItems = values.length;

        int[][] knapsackMatrix = new int[totalNumberItems + 1][totalWeight + 1];

        for(int maxItems = 1; maxItems <= totalNumberItems; maxItems++) {
            for(int remainingCapacity = 1; remainingCapacity <= totalWeight; remainingCapacity++) {

                int previousMaxValue = knapsackMatrix[maxItems - 1][remainingCapacity];
                int maxValueWithCurrentWeight = 0;

                int currentWeight = weights[maxItems - 1];

                if(remainingCapacity - currentWeight >= 0) {
                    maxValueWithCurrentWeight = values[maxItems - 1] + knapsackMatrix[maxItems - 1][remainingCapacity - currentWeight];
                }

                knapsackMatrix[maxItems][remainingCapacity] = previousMaxValue > maxValueWithCurrentWeight ? previousMaxValue : maxValueWithCurrentWeight;
            }
        }

        return knapsackMatrix[totalNumberItems][totalWeight];
    }

}
