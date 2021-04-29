package com.trees.model;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Node {

    // Structure of our node, a value, one left child,
    // one right child
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }

    // Inserting a value
    public void insert(int insertVal) {

        // If the value of this node is greater than the incoming
        // value then if left is free we add it there, otherwise
        // pass it to the left node to handle
        if(val >= insertVal) {
            if(left == null) {
                left = new Node(insertVal);
            } else {
                left.insert(insertVal);
            }
        // If the value is greater we do the same for the right
        } else {
            if(right == null) {
                right = new Node(insertVal);
            } else {
                right.insert(insertVal);
            }
        }
    }

    public void inOrderTraversal() {
        if(left != null) {
            left.inOrderTraversal();
        }
        System.out.println(val);
        if(right != null) {
            right.inOrderTraversal();
        }
    }

    public void preOrderTraversal() {
        System.out.println(val);
        if(left != null) {
            left.preOrderTraversal();
        }
        if(right != null) {
            right.preOrderTraversal();
        }
    }

    public void postOrderTraversal() {
        if(left != null) {
            left.postOrderTraversal();
        }
        if(right != null) {
            right.postOrderTraversal();
        }
        System.out.println(val);
    }

    public void breadthFirstSearch() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.println(node.val);
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
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

    public boolean search(int toFind) {
        if(val == toFind) {
            return true;
        }
        if(val >= toFind) {
            if(left == null) {
                return false;
            } else {
                return left.search(toFind);
            }
        } else {
            if(right == null) {
                return false;
            } else {
                return right.search(toFind);
            }
        }
    }

    public Node delete(Node root, int valueToDelete, Node parentNode) {

        // If we're looking for a node smaller than the current node then
        // we need to look to the left
        if(valueToDelete < val) {
            if(left != null) {
                return left.delete(root, valueToDelete, this);
            }
        // Or if it's greater than the current node look to the right
        } else if (valueToDelete > val){
            if(right != null) {
                return right.delete(root, valueToDelete, this);
            }
        // This means we've found the node. We're assuming there's only
        // one
        } else {

            // This is the case where we have two children
            if(left != null && right != null) {

                // Find the smallest node in the sub tree and move it
                // up here, as well as its parent node so we can remove
                // references
                NodePair smallestNodePair = findSmallestNodeInTree(right, this);
                Node smallestNode = smallestNodePair.child;
                Node smallestNodeParent = smallestNodePair.parent;

                smallestNode.left = left;
                smallestNode.right = right;

                // We know it's left as we were looking for the SMALLEST
                // node, which will be left of the parent
                smallestNodeParent.left = null;

                // If we have a parent node then we need to point to
                // the new smallest node
                if (parentNode != null) {
                    if (parentNode.left == this) {
                        parentNode.left = smallestNode;
                    }
                    if (parentNode.right == this) {
                        parentNode.right = smallestNode;
                    }
                } else {
                    // We're returning the new root from the function,
                    // if there was no parent node then we must have
                    // a new root
                    return smallestNode;
                }

                // These are the cases where we have one child. We need to make
                // sure we point the parent node to the correct child of this node.
                // Remember, if there's no parent then we just return the node as
                // we have nothing else to link it to
            } else if(left == null && right != null) {
                if(parentNode != null) {
                    if (parentNode.left == this) {
                        parentNode.left = right;
                    }
                    if (parentNode.right == this) {
                        parentNode.right = right;
                    }
                } else {
                    return right;
                }
            } else if(right == null && left != null) {
                if(parentNode != null) {
                    if (parentNode.left == this) {
                        parentNode.left = left;
                    }
                    if (parentNode.right == this) {
                        parentNode.right = left;
                    }
                } else {
                    return left;
                }
            // Else we have no children and we just dereference it. If there's
            // nothing to dereference it from then we just return null
            } else {
                if(parentNode != null) {
                    if (parentNode.left == this) {
                        parentNode.left = null;
                    }
                    if (parentNode.right == this) {
                        parentNode.right = null;
                    }
                } else {
                    return null;
                }
            }
        }
        return root;
    }

    // Function for finding the smallest node in the tree and returning
    // it and its parent
    private NodePair findSmallestNodeInTree(Node node, Node parentNode) {
        if(node.left == null) {
            return new NodePair(parentNode, node);
        }
        return findSmallestNodeInTree(node.left, node);
    }

    // Convenient wrapper class for passing back a node and its parent
    private class NodePair {
        Node parent;
        Node child;

        public NodePair(Node parent, Node child) {
            this.parent = parent;
            this.child = child;
        }
    }

    public boolean isBalanced() {
        // Check to see if this tree is balanced. The current height is
        // 0
        return isBalancedAndHeight().balanced;
    }

    private HeightBalanced isBalancedAndHeight() {

        System.out.println("");
        System.out.println("Current node value is " + val);

        // If left is null and right is null we have reached the bottom of
        // the tree, so we know it is balanced, and the maximum subheight
        // of this branch is the current height.
        if(left == null && right == null){

            System.out.println("Detected leaf node");
            return new HeightBalanced(1, true);

        // Otherwise we may have a case where the left branch is null, but
        // the right branch isn't.
        } else if(left == null && right != null) {

            System.out.println("Detected right node is not null, but left node is");

            // Check to see if the right branch is balanced, if it isn't we can return
            // early as we know the rest of the tree isn't balanced.
            HeightBalanced rightHeightBalanced = right.isBalancedAndHeight();

            System.out.println("Right balanced is " + rightHeightBalanced.balanced);
            System.out.println("Right height is " + rightHeightBalanced.maxSubheight);

            if(!rightHeightBalanced.balanced) {

                System.out.println("Returning right isn't balanced");
                return new HeightBalanced(-1, false);

            // Otherwise we know the max subtree height of the left branch is zero,
            // so we need the right subtree height to be 1 or else the difference
            // will be too great
            } else {
                if(rightHeightBalanced.maxSubheight != 1) {
                    System.out.println("Discovered right node isn't balanced");
                    return new HeightBalanced(-1, false);
                } else {
                    System.out.println("Right node is balanced, returning max subheight " + rightHeightBalanced.maxSubheight);
                    return new HeightBalanced(rightHeightBalanced.maxSubheight + 1, true);
                }
            }
        } else if(left != null && right == null) {

            System.out.println("Detected left node is not null, but right node is");

            // Check to see if the left branch is balanced, if it isn't we can return
            // early.
            HeightBalanced leftHeightBalanced = left.isBalancedAndHeight();

            System.out.println("Left balanced is " + leftHeightBalanced.balanced);
            System.out.println("Left height is " + leftHeightBalanced.maxSubheight);

            if(!leftHeightBalanced.balanced) {

                System.out.println("Returning left isn't balanced");
                return new HeightBalanced(-1, false);

                // Otherwise we know the max subtree height of the right branch is zero,
                // so we need the right subtree height to be 1 or else the difference
                // will be too great
            } else {
                if(leftHeightBalanced.maxSubheight != 1) {
                    System.out.println("Discovered left node isn't balanced " + val);
                    return new HeightBalanced(-1, false);
                } else {
                    System.out.println("Left node is balanced, returning max subheight " + leftHeightBalanced.maxSubheight);
                    return new HeightBalanced(leftHeightBalanced.maxSubheight + 1, true);
                }
            }

        // This is the case where both nodes are not null, and we need to
        } else {

            System.out.println("Both nodes are not null");

            HeightBalanced leftHeightBalanced = left.isBalancedAndHeight();
            HeightBalanced rightHeightBalanced = right.isBalancedAndHeight();

            System.out.println("Left hand node is balanced " + leftHeightBalanced.balanced + " " + leftHeightBalanced.maxSubheight);
            System.out.println("Right hand node is balanced " + rightHeightBalanced.balanced + " " + rightHeightBalanced.maxSubheight);

            if(!(rightHeightBalanced.balanced && leftHeightBalanced.balanced)) {
                System.out.println("Both nodes are not balanced");
                return new HeightBalanced(-1, false);
            } else {
                if(abs(leftHeightBalanced.maxSubheight - rightHeightBalanced.maxSubheight) > 1) {
                    System.out.println("Difference in heights is greater than one");
                    return new HeightBalanced(-1, false);
                } else {
                    int maxSubheight = max(leftHeightBalanced.maxSubheight, rightHeightBalanced.maxSubheight) + 1;
                    System.out.println("Max sub height is " + maxSubheight);
                    return new HeightBalanced(maxSubheight, true);
                }
            }

        }
    }

    private class HeightBalanced {
        int maxSubheight;
        boolean balanced;

        public HeightBalanced(int maxSubheight, boolean balanced) {
            this.maxSubheight = maxSubheight;
            this.balanced = balanced;
        }
    }
}
