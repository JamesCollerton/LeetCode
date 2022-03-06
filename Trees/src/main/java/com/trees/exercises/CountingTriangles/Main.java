package com.trees.exercises.CountingTriangles;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
// Add any extra import statements you may need here


class Main {

    class Sides {
        int a;
        int b;
        int c;
        Sides(int a,int b,int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    // Add any helper functions you may need here


    int countDistinctTriangles(ArrayList<Sides> arr) {
        // Write your code here

        int[][] sortedTriangles = new int[arr.size()][3];

        for(int i = 0; i < arr.size(); i++) {

            Sides side = arr.get(i);

            int[] sides = new int[]{side.a, side.b, side.c};
            Arrays.sort(sides);

            sortedTriangles[i] = sides;
        }

        Arrays.sort(sortedTriangles, (a, b) -> {
            if(a[0] == b[0]) {
                if(a[1] == b[1]) {
                    if(a[2] == b[2]) {
                        return 0;
                    } else {
                        return a[2] - b[2];
                    }
                } else {
                    return a[1] - b[1];
                }
            } else {
                return a[0] - b[0];
            }
        });

        int[] previousTriangle = new int[]{-1, -1, -1};

        int numberTriangles = 0;

        for(int i = 0; i < sortedTriangles.length; i++) {
            if(!trianglesEqual(previousTriangle, sortedTriangles[i])) {
                numberTriangles++;
            }
            previousTriangle = sortedTriangles[i];
        }

        return numberTriangles;
    }

    private boolean trianglesEqual(int[] triangleA, int[] triangleB) {
        return triangleA[0] == triangleB[0] && triangleA[1] == triangleB[1] && triangleB[2] == triangleB[2];
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
        ArrayList<Sides> arr_1 = new ArrayList<>();
        arr_1.add(new Sides(7, 6, 5));
        arr_1.add(new Sides(5, 7, 6));
        arr_1.add(new Sides(8, 2, 9));
        arr_1.add(new Sides(2, 3, 4));
        arr_1.add(new Sides(2, 4, 3));
        int expected_1 = 3;
        int output_1 = countDistinctTriangles(arr_1);
        check(expected_1, output_1);

        ArrayList<Sides> arr_2 = new ArrayList<>();
        arr_2.add(new Sides(3, 4, 5));
        arr_2.add(new Sides(8, 8, 9));
        arr_2.add(new Sides(7, 7, 7));
        int expected_2 = 3;
        int output_2 = countDistinctTriangles(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new Main().run();
    }
}