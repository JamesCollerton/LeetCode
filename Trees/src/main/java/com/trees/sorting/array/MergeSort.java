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

        int midPoint = arr.length / 2;

        int[] leftSubArray = new int[midPoint];
        int[] rightSubArray = new int[arr.length - midPoint];

        for(int i = 0; i < midPoint; i++) {
            leftSubArray[i] = arr[i];
        }

        for(int i = midPoint; i < arr.length; i++) {
            rightSubArray[i - midPoint] = arr[i];
        }

        mergeSort(leftSubArray);
        mergeSort(rightSubArray);

        merge(arr, leftSubArray, rightSubArray);
    }

    private static void merge(int[] arr, int[] leftSubArray, int[] rightSubArray) {

        int leftPointer = 0;
        int rightPointer = 0;
        int i = 0;

        while(leftPointer < leftSubArray.length && rightPointer < rightSubArray.length) {
            if(leftSubArray[leftPointer] < rightSubArray[rightPointer]) {
                arr[i++] = leftSubArray[leftPointer++];
            } else {
                arr[i++] = rightSubArray[rightPointer++];
            }
        }

        while(leftPointer < leftSubArray.length) {
            arr[i++] = leftSubArray[leftPointer++];
        }

        while(rightPointer < rightSubArray.length) {
            arr[i++] = rightSubArray[rightPointer++];
        }
    }

}
