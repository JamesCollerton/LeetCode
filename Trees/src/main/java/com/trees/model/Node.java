package com.trees.model;

import java.util.LinkedList;
import java.util.Queue;

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

    
}
