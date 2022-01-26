package com.trees.colourfulnumber;

import java.util.HashSet;
import java.util.Set;

public class ColourfulNumber {

    public static void main(String[] args) {
        System.out.println(isColourful(new int[]{3, 2, 4, 5}));
        System.out.println(isColourful(new int[]{3, 2, 6}));
    }

    private static boolean isColourful(int[] arr) {
        if(arr.length == 1) {
            return true;
        }

        Set<Integer> seen = new HashSet<>();

        int p1 = 0;
        int p2 = 0;
        int counter = arr[0];

        boolean keepGoing = true;

        while(p1 < arr.length) {
            if(seen.contains(counter)) {
                return false;
            }
            seen.add(counter);
            if(p1 == 0 && p2 == arr.length - 1) {
                p1 = 1;
                p2 = 1;
                counter = arr[p1];
            } else if(p2 == arr.length - 1) {
                p1++;
                p2 = p1;
                if(p1 < arr.length) {
                    counter = arr[p1];
                }
            } else {
                p2++;
                counter *= arr[p2];
            }
        }

        return true;
    }

}
