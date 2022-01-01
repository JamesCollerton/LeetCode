package com.trees.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 7, 9, 15, 22, 1, 8, 6};

        mergeSort(arr);

        Arrays.stream(arr).forEach(System.out::println);

    }

    private static void mergeSort(int[] arr) {

        int length = arr.length;

        if(length < 2) {
            return;
        }

        int midPoint = length / 2;
        int[] leftArray = new int[midPoint];
        int[] rightArray = new int[length - midPoint];

        for(int i = 0; i < midPoint; i++) {
            leftArray[i] = arr[i];
        }

        for(int i = midPoint; i < arr.length; i++) {
            rightArray[i - midPoint] = arr[i];
        }

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(arr, leftArray, rightArray);
    }

    private static void merge(int[] arr, int[] leftArray, int[] rightArray) {

        int i = 0, j = 0, k = 0;

        while(i < leftArray.length && j < rightArray.length) {
            if(leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else if(leftArray[i] > rightArray[j]) {
                arr[k++] = rightArray[j++];
            }
        }

        while(i < leftArray.length) {
            arr[k++] = leftArray[i++];
        }

        while(j < rightArray.length) {
            arr[k++] = rightArray[j++];
        }

    }

}
