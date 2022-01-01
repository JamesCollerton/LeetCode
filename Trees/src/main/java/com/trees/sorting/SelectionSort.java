package com.trees.sorting;

public class SelectionSort {

    // Go from the pointer through the rest of the array and find
    // the minimum, put it in the pointer place.
    public static void main(String[] args) {

        int[] arr = new int[]{7, 3, 1, 4, 2, 9, 7};

        int pointer = 0;

        while(pointer < arr.length) {

            int minIndex = pointer;

            for(int i = pointer; i < arr.length; i++) {
                minIndex = arr[minIndex] < arr[i] ? minIndex : i;
            }

            int temp = arr[pointer];
            arr[pointer] = arr[minIndex];
            arr[minIndex] = temp;

            pointer++;
        }

        for(int i : arr) {
            System.out.println(i + " ");
        }

    }

}
