package com.trees;

import com.trees.model.Node;
import com.trees.utilities.BinarySearchTreeGenerator;

import java.util.LinkedList;
import java.util.List;

public class CreateBinarySearchTree {

    public static void main(String[] args) {

        // Values we would like to make a binary search tree from
        List<Integer> vals = List.of(10, 5, 15, 2, 7, 12);

        // Class for generating a binary search tree from the list
        Node root = new BinarySearchTreeGenerator().generate(vals);

        System.out.println("\nPre-order traversal");
        root.preOrderTraversal();

        System.out.println("\nIn-order traversal");
        root.inOrderTraversal();

        System.out.println("\nPost-order traversal");
        root.postOrderTraversal();

        System.out.println("\nBreadth-first traversal");
        root.breadthFirstSearch();

        System.out.println("\nFind value 5");
        System.out.println("5 exists is: " + root.search(5));

        System.out.println("\nFind value 100");
        System.out.println("100 exists is: " + root.search(100));

        System.out.println("\nDelete value 2");
        root.delete(root, 2, null).print();

        root = new BinarySearchTreeGenerator().generate(vals);

        System.out.println("\nDelete value 15");
        root.delete(root,15, null).print();

        root = new BinarySearchTreeGenerator().generate(vals);

        System.out.println("\nDelete value 10");
        root.delete(root, 10, null).print();

        root = new BinarySearchTreeGenerator().generate(List.of(10));

        System.out.println("\nDelete value 10");
        System.out.println(root.delete(root, 10, null));

        root = new BinarySearchTreeGenerator().generate(List.of(10, 5));

        System.out.println("\nDelete value 10");
        root.delete(root, 10, null).print();

        root = new BinarySearchTreeGenerator().generate(List.of(10, 15));

        System.out.println("\nDelete value 10");
        root.delete(root, 10, null).print();
    }

}
