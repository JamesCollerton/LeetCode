package com.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = new int[]{7, 4, 2, 3, 1, 9, 8, 6};

        mergeSort(arr);

        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void mergeSort(int[] arr) {

        int length = arr.length;

        if (length < 2) {
            return;
        }

        int midPoint = length / 2;
        int[] leftSubArray = new int[midPoint];
        int[] rightSubArray = new int[length - midPoint];

        for(int i = 0; i < midPoint; i++) {
            leftSubArray[i] = arr[i];
        }
        for(int i = midPoint; i < length; i++) {
            rightSubArray[i - midPoint] = arr[i];
        }

        mergeSort(leftSubArray);
        mergeSort(rightSubArray);

        merge(arr, leftSubArray, rightSubArray);
    }

    private static void merge(
            int[] arr, int[] leftSubArray, int[] rightSubArray) {

        int leftLength = leftSubArray.length;
        int rightLength = rightSubArray.length;

        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {
            if (leftSubArray[i] <= rightSubArray[j]) {
                arr[k++] = leftSubArray[i++];
            }
            else {
                arr[k++] = rightSubArray[j++];
            }
        }
        while (i < leftLength) {
            arr[k++] = leftSubArray[i++];
        }
        while (j < rightLength) {
            arr[k++] = rightSubArray[j++];
        }
    }

}
