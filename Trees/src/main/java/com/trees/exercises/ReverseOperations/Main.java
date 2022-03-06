package com.trees.exercises.ReverseOperations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// Add any extra import statements you may need here


class Main {

    class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }

    // Add any helper functions you may need here


    Node reverse(Node head) {

        Map<Node, Node> startToEndBlockMap = new HashMap<>();

        Node previous = null;
        Node node = head;
        boolean inBlock = false;

        Node startOfBlock = null;

        while(node != null) {

            if(node.data % 2 == 0 && !inBlock) {
                startOfBlock = node;
                inBlock = true;
            } else if(node.data % 2 == 1 && inBlock) {
                inBlock = false;
                startToEndBlockMap.put(startOfBlock, previous);
            }

            previous = node;
            node = node.next;
        }

        if(inBlock) {
            startToEndBlockMap.put(startOfBlock, previous);
        }

        previous = null;
        node = head;

        while(node != null) {

            if(startToEndBlockMap.containsKey(node)) {

                if(previous != null) {
                    previous.next = null;
                }

                Node lastEvenNode = startToEndBlockMap.get(node);

                Node nextOddNode = lastEvenNode == null ? null : lastEvenNode.next;

                if(lastEvenNode != null) {
                    lastEvenNode.next = null;
                }

                reverseSubArray(node);

                if(previous != null) {
                    previous.next = lastEvenNode;
                } else {
                    head = lastEvenNode;
                }

                node.next = nextOddNode;

                previous = node;
                node = nextOddNode;
            } else {
                previous = node;
                node = node.next;
            }

        }

        return head;
    }

    private void reverseSubArray(Node startNode) {

        if(startNode.next == null) {
            return;
        }

        Node node = startNode;
        Node nextNode = startNode.next;
        Node nextNextNode = startNode.next.next;

        while(nextNode != null) {

            nextNode.next = node;

            node = nextNode;
            nextNode = nextNextNode;
            if(nextNextNode != null) {
                nextNextNode = nextNextNode.next;
            }

        }
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void printLinkedList(Node head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.data);
            head = head.next;
            if (head != null)
                System.out.print(" ");
        }
        System.out.print("]");
    }
    void check(Node expectedHead, Node outputHead) {
        boolean result = true;
        Node tempExpectedHead = expectedHead;
        Node tempOutputHead = outputHead;
        while (expectedHead != null && outputHead != null) {
            result &= (expectedHead.data == outputHead.data);
            expectedHead = expectedHead.next;
            outputHead = outputHead.next;
        }
        if (!(expectedHead == null && outputHead == null)) result = false;

        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printLinkedList(tempExpectedHead);
            System.out.print(" Your output: ");
            printLinkedList(tempOutputHead);
            System.out.println();
        }
        test_case_number++;
    }
    Node createLinkedList(int[] arr) {
        Node head = null;
        Node tempHead = head;
        for (int v : arr) {
            if (head == null) {
                head = new Node(v);
                tempHead = head;
            } else {
                head.next = new Node(v);
                head = head.next;
            }
        }
        return tempHead;
    }

    public void run() {

        int[] arr_1 = {1, 2, 8, 9, 12, 16};
        int[] expected1 = {1, 8, 2, 9, 16, 12};
        Node head_1 = createLinkedList(arr_1);
        Node expected_1 = createLinkedList(expected1);
        Node output_1 = reverse(head_1);
        check(expected_1, output_1);

        int[] arr_2 = {2, 18, 24, 3, 5, 7, 9, 6, 12};
        int[] expected2 = {24, 18, 2, 3, 5, 7, 9, 12, 6};
        Node head_2 = createLinkedList(arr_2);
        Node expected_2 = createLinkedList(expected2);
        Node output_2 = reverse(head_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new Main().run();
    }
}
