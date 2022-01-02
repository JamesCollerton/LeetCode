package com.trees.sorting.array;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 6, 2, 8, 9, 10, 8, 7};

        int pointer = 1;

        while(pointer < arr.length) {

            int pointerValue = arr[pointer];
            int i = pointer;

            while(i > 0 && arr[i - 1] > pointerValue) {
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
