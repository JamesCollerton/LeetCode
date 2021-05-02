package com.trees.model;

public class AvlNode {

    public int val;
    public int height;
    public AvlNode left;
    public AvlNode right;

    // When we initialise a node it will have height of 1
    public AvlNode(int val) {
        this.val = val;
        height = 1;
    }

    public void print() {
        System.out.println(val);
        if(left != null) {
            left.print();
        }
        if(right != null) {
            right.print();
        }
    }

}
