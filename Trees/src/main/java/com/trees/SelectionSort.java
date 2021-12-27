package com.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        int pointer = 0;

        while(pointer < list.size()) {

            int min = Integer.MAX_VALUE;
            int minIndex = pointer;

            for(int i = pointer; i < list.size(); i++) {
                if(list.get(i) < min) {
                    min = list.get(i);
                    minIndex = i;
                }
            }

            int temp = list.get(pointer);
            list.set(pointer, min);
            list.set(minIndex, temp);

            pointer++;
        }

        list.forEach(System.out::println);
    }

}
