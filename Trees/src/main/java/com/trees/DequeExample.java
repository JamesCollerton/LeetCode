package com.trees;

import java.util.Deque;
import java.util.LinkedList;

public class DequeExample {

    public static void main(String[] args) {

        // Note that deque is an interface and so we need an implementation
        Deque<Integer> deque = new LinkedList<>();

        // Here we add items at the start and end of the deque, leaving us
        // with result [1, 2]
        deque.offerFirst(1);
        deque.offerLast(2);

        // These will return 1 and 2 respectively
        deque.peekFirst();
        deque.peekLast();

        for(Integer item: deque) {
            System.out.println(item);
        }

    }

}
