package com.trees.utilities;

import com.trees.model.Node;

import java.util.Arrays;
import java.util.List;

public class BinarySearchTreeGenerator {

    public Node generate(List<Integer> vals) {

        Node root = null;

        // If the list is not empty or null
        if(vals != null && vals.size() != 0) {

            // The first item can be our root
            root = new Node(vals.get(0));

            // Go through all items and add them to the root
            List<Integer> remainingVals = vals.subList(1, vals.size());
            for (int val : remainingVals) {
                root.insert(val);
            }
        }

        return root;
    }
}
