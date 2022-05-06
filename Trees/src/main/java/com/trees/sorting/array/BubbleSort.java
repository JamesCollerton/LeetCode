package com.trees.sorting.array;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 4, 7, 9, 10, 11, 7};

        int pointer = arr.length - 1;

        while(pointer > 0) {

            for(int i = 0; i < pointer; i++) {
                if(arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }

            pointer--;
        }

        for(int num: arr) {
            System.out.print(num + " ");
        }

    }

}
