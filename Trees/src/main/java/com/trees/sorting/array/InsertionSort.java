package com.trees.sorting.array;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 6, 2, 8, 9, 10, 8, 7, 3};

        for(int pointer = 0; pointer < arr.length; pointer++) {

            int minIndex = pointer;

            for(int i = pointer + 1; i < arr.length; i++) {
                if(arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
            }

            int temp = arr[pointer];
            arr[pointer] = arr[minIndex];
            arr[minIndex] = temp;

        }

        for(int i: arr) {
            System.out.print(i + " ");
        }
    }

}
