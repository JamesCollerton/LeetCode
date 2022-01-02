package com.trees.sorting.array;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 4, 7, 9, 10, 11, 7};

        int pointer = 0;

        while(pointer < arr.length) {

            for(int i = 0; i < arr.length - 1 - pointer; i++) {
                if(arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }

            pointer++;
        }

        for(int i: arr) {
            System.out.print(i + " ");
        }

    }

}
