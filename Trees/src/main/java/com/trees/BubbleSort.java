package com.trees;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        int pointer = 0;

        while(pointer < list.size()) {

            for(int i = 0; i < list.size() - 1 - pointer; i++) {
                if(list.get(i) > list.get(i + 1)) {
                    int temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }

            pointer++;
        }

        list.forEach(System.out::println);
    }

}
