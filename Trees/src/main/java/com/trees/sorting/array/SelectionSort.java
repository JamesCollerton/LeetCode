package com.trees.sorting.array;

public class SelectionSort {

    // Go from the pointer through the rest of the array and find
    // the minimum, put it in the pointer place.
    public static void main(String[] args) {

        int[] arr = new int[]{7, 3, 1, 4, 2, 9, 7};

        for(int pointer = 0; pointer < arr.length; pointer++) {
            int minIndex = pointer;
            for(int pointerTwo = pointer; pointerTwo < arr.length; pointerTwo++) {
                if(arr[pointerTwo] < arr[minIndex]) {
                    minIndex = pointerTwo;
                }
            }
            int temp = arr[pointer];
            arr[pointer] = arr[minIndex];
            arr[minIndex] = temp;
        }

        for(int num: arr) {
            System.out.print(num + " ");
        }

    }

}
