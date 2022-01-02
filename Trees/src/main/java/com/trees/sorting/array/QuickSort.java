package com.trees.sorting.array;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 6, 2, 8, 9, 10, 8, 7};

        quickSort(arr, 0, arr.length - 1);

        Arrays.stream(arr).forEach(System.out::println);

    }

    private static void quickSort(int[] arr, int start, int finish) {

        if(start < finish) {

            int partitionIndex = partition(arr, start, finish);

            quickSort(arr, start, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, finish);
        }

    }

    private static int partition(int[] arr, int start, int finish) {

        int pivot = arr[finish];
        int i = start - 1;

        for(int j = start; j < finish; j++) {

            if(arr[j] < pivot) {
                i++;

                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[finish];
        arr[finish] = temp;

        return i + 1;
    }

}