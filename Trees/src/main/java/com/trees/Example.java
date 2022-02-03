package com.trees;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Example {

    public static void main(String[] args) {

        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();
        Stack<Integer> stackC = new Stack<>();

        stackA.add(1);
        stackB.add(1);
        stackB.add(2);
        stackC.add(2);

        Queue<Stack<Integer>> queue = new PriorityQueue<>((a, b) -> {
            if(a.peek() < b.peek()) {
                return -1;
            } else if(a.peek() > b.peek()) {
                return 1;
            } else {
                return b.size() - a.size();
            }
        });

        queue.add(stackA);
        queue.add(stackB);
        queue.add(stackC);

        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }

}
