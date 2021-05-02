package com.trees.model;

import static java.lang.Math.max;

public class AvlTree {

    /*

        We pass in a node of structure

            top
           /
        left
            \
            right

        We then want to perform a rotation such that we receive

            left
                \
                top
                /
            right

     */
    private AvlNode rotateRight(AvlNode top) {

        // Retrieve the current nodes
        AvlNode left = top.left;
        AvlNode right = left.right;

        // Perform rotation
        left.right = top;
        top.left = right;

        // Update heights, the right subtree hasn't changed
        top.height = max(height(top.left), height(top.right)) + 1;
        left.height = max(height(left.left), height(left.right)) + 1;

        // Return new root
        return left;
    }

    /*

        We pass in a node of structure

            top
                \
                right
                /
              left

        We then want to perform a rotation such that we receive

            right
                \
                top
                  \
                left

     */
    private AvlNode rotateLeft(AvlNode top) {
        AvlNode right = top.right;
        AvlNode left = right.left;

        // Perform rotation
        right.left = top;
        top.right = left;

        //  Update heights
        top.height = max(height(top.left), height(top.right)) + 1;
        right.height = max(height(right.left), height(right.right)) + 1;

        // Return new root
        return right;
    }

    public AvlNode insert(AvlNode node, int val) {

        // This part covers the regular BST insertion. We recurse
        // down the tree waiting for the first point where we reach
        // a leaf, we then create a node here.
        if (node == null) {
            return (new AvlNode(val));
        }

        // Here we set the left and right pointers of the node. However,
        // as most of the cases (except for the one where we create the
        // new node) we are returning the unchanged node, this has no
        // effect
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        } else {
            return node;
        }

        // Now we rebalance the tree
        return rebalance(node);
    }

    private AvlNode rebalance(AvlNode node) {
        // We update the height of this node
        node.height = 1 + max(height(node.left), height(node.right));

        // We retrieve if it is balanced or not
        int balance = getBalance(node);

        // These are the four cases

        // If the right subtree if bigger than the left
        if(balance > 1) {
            // And it is the right subtree of the right subtree that is causing the imbalance
            if(height(node.right.right) > height(node.right.left)) {
                node = rotateLeft(node);
            // Othwerise it is the left subtree of the right subtree causing the imbalance and we need two rotations
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        // We do the mirror case!
        } else if(balance < -1) {
            if (height(node.left.left) > height(node.left.right))
                node = rotateRight(node);
            else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }

        // Return the node post-rotation
        return node;
    }

    private int height(AvlNode n) {
        return n == null ? 0 : n.height;
    }

    private int getBalance(AvlNode n) {
        return n == null ? 0 : height(n.right) - height(n.left);
    }

}
