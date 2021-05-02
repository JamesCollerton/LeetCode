package com.trees;

import com.trees.model.AvlNode;
import com.trees.model.AvlTree;

import java.util.List;

public class AVLNodeExamples {

    public static void main(String[] args) {

        List<Integer> vals = List.of(6, 5, 4, 12, 10, 15, 17);
        AvlTree avlTree = new AvlTree();
        AvlNode root = null;

        for (int val: vals) {
            root = avlTree.insert(root, val);
        }

        root.print();

    }

}
