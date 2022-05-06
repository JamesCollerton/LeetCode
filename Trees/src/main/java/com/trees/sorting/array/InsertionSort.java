package com.trees.sorting.array;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 6, 2, 8, 9, 10, 8, 7, 3};

        // 4, 2, 3, 1
        for(int pointer = 1; pointer < arr.length; pointer++) {

            int moving = pointer - 1;
            int temp = arr[pointer];

            while(moving >= 0 && arr[moving] > temp) {
                arr[moving + 1] = arr[moving];
                moving--;
            }

            arr[moving + 1] = temp;
        }

        for(int i: arr) {
            System.out.print(i + " ");
        }
    }

}
