package com.trees.sorting.array;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 7, 9, 15, 22, 1, 8, 6};

        mergeSort(arr);

        for(int num: arr) {
            System.out.print(num + " ");
        }
    }

    private static void mergeSort(int[] arr) {
        if(arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;

        int[] leftSubArray = new int[mid];
        int[] rightSubArray = new int[arr.length - mid];

        for(int i = 0; i < mid; i++) {
            leftSubArray[i] = arr[i];
        }

        for(int i = 0; i < arr.length - mid; i++) {
            rightSubArray[i] = arr[mid + i];
        }

//        System.arraycopy(arr, 0, leftSubArray, 0, mid);
//        System.arraycopy(arr, mid + 1, rightSubArray, 0, arr.length - mid);

        mergeSort(leftSubArray);
        mergeSort(rightSubArray);

        merge(arr, leftSubArray, rightSubArray);
    }

    private static void merge(int[] arr, int[] leftSubArray, int[] rightSubArray) {

        int leftPointer = 0;
        int rightPointer = 0;
        int arrPointer = 0;

        while (leftPointer < leftSubArray.length && rightPointer < rightSubArray.length) {
            if(leftSubArray[leftPointer] < rightSubArray[rightPointer]) {
                arr[arrPointer] = leftSubArray[leftPointer];
                arrPointer++;
                leftPointer++;
            } else {
                arr[arrPointer] = rightSubArray[rightPointer];
                arrPointer++;
                rightPointer++;
            }
        }

        while (leftPointer < leftSubArray.length) {
            arr[arrPointer] = leftSubArray[leftPointer];
            arrPointer++;
            leftPointer++;
        }

        while (rightPointer < rightSubArray.length) {
            arr[arrPointer] = rightSubArray[rightPointer];
            arrPointer++;
            rightPointer++;
        }

    }

}
