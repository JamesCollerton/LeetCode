package com.trees.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = new int[]{4, 3, 2, 1, 0};

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

        for(Integer i : arr) {
            System.out.print(i + " ");
        }
    }

}
