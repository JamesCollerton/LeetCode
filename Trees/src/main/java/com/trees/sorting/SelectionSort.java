package com.trees.sorting;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = new int[]{7, 3, 1, 4, 2, 9, 7};

        int pointer = 0;

        while(pointer < arr.length) {

            int minIndex = pointer;

            for(int i = pointer; i < arr.length; i++) {
                minIndex = arr[i] < arr[minIndex] ? i : minIndex;
            }

            int temp = arr[pointer];
            arr[pointer] = arr[minIndex];
            arr[minIndex] = temp;

            pointer++;
        }

        for(int i: arr) {
            System.out.print(i + " ");
        }

    }

}
