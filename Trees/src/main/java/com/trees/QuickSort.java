package com.trees;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = new int[]{7, 4, 2, 3, 1, 9, 8, 6};

        quickSort(arr, 0, arr.length - 1);

        Arrays.stream(arr).forEach(System.out::println);
    }

    // As we recursively sort in the arrays we need to pass in the
    // indexes of where the partition we're looking at begins and
    // ends (inclusive). We don't need to return anything as we're
    // sorting in place.
    public static void quickSort(int arr[], int start, int finish) {

        // As long as we have something to sort.
        if (start < finish) {

            // This is the new partition index, where we want
            // to split between
            int partitionIndex = partition(arr, start, finish);

            // Recursively sort the two halves of the partition
            quickSort(arr, start, partitionIndex-1);
            quickSort(arr, partitionIndex+1, finish);
        }
    }

    // This is the method for partitioning.
    private static int partition(int arr[], int start, int finish) {

        // Each time we choose the last element in
        // the partition as the pivot
        int pivot = arr[finish];

        // The i counter is the one behind the beginning as
        // it will be increased into the partition in the case
        // where the current item is less than the pivoy
        int i = start - 1;

        // We go through every item from the beginning
        // to the finish of the partition.
        for (int j = start; j < finish; j++) {

            // If the item is less than the pivot item then we
            // want to put it at the start of the partition, where
            // i tracks the next available place at the start
            // of the partition.
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Now i is at the finish of the values less than the pivot,
        // and the pivot is at the finish, we can swap the pivot in
        // place.
        int temp = arr[i + 1];
        arr[i + 1] = arr[finish];
        arr[finish] = temp;

        // We know that all the values between the start and i + 1
        // are less than the pivot, and all values between i + 1 and
        // the finish are greater than, so we pass this value back as
        // the next partition index.
        return i+1;
    }

}
