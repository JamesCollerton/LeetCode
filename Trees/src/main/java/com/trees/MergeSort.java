package com.trees;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(1);

        int pointer = 1;

        while(pointer < list.size()) {

            int tempValue = list.get(pointer);

            int i = pointer;

            while(i > 0 && list.get(i - 1) > tempValue) {
                list.set(i, list.get(i - 1));
                i--;
            }

            list.set(i, tempValue);

            pointer++;
        }

        list.forEach(System.out::println);
    }

}
