package com.trees.exercises.CountingTriangles;

import java.io.*;
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

        int[][] sidesArr = new int[arr.size()][3];

        for(int i = 0; i < arr.size(); i++) {
            Sides sides = arr.get(i);
            int[] newArr = new int[]{sides.a, sides.b, sides.c};
            Arrays.sort(newArr);
            sidesArr[i] = newArr;
        }

        Arrays.sort(sidesArr, Comparator.comparingInt(a -> a[0]));

        int pointerOne = 0;
        int count = 0;

        while(pointerOne < sidesArr.length) {
            count++;
            int pointerTwo = pointerOne + 1;
            while(pointerTwo < sidesArr.length && trianglesSame(sidesArr[pointerOne], sidesArr[pointerTwo])) {
                pointerTwo++;
            }
            pointerOne = pointerTwo;
        }

        return count;
    }

    boolean trianglesSame(int[] triangleOne, int[] triangleTwo) {
        return triangleOne[0] == triangleTwo[0] && triangleOne[1] == triangleTwo[1] && triangleOne[2] == triangleTwo[2];
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