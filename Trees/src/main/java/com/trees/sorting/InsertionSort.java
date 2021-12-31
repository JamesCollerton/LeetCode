package com.trees.sorting;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 6, 2, 8, 9, 10, 8, 7};

        // Start at one as the value at 0 is de-facto sorted
        int pointer = 1;

        while(pointer < arr.length) {

            int i = pointer;
            int pointerValue = arr[pointer];

            // If we have the state 1, 3, 4 and pointer is at 2 then
            // our i starts at index 3. If 2 is less than 4 then we
            // want to move 4 along into our current index.
            while(i > 0 && pointerValue < arr[i - 1]) {
                arr[i] = arr[i - 1];
                i--;
            }

            arr[i] = pointerValue;

            pointer++;
        }

        for(int i: arr) {
            System.out.print(i + " ");
        }
    }

}
