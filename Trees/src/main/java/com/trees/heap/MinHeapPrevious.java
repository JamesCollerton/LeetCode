package com.trees.heap;

// Java Program to Implement Heaps
// by Illustrating Min heap

// Main class (MinHeapPrevious)
public class MinHeapPrevious {

    // Member variables of this class
    private int[] heap;
    private int size;
    private int maxsize;

    // Initializing front as static with unity
    private static final int FRONT = 1;

    // Constructor of this class
    public MinHeapPrevious(int maxsize)
    {

        // This keyword refers to current object itself
        this.maxsize = maxsize;
        this.size = 0;

        heap = new int[this.maxsize + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    // Method 1
    // Returning the position of
    // the parent for the node currently
    // at pos
    private int parent(int pos) { return pos / 2; }

    // Method 2
    // Returning the position of the
    // left child for the node currently at pos
    private int leftChild(int pos) { return (2 * pos); }

    // Method 3
    // Returning the position of
    // the right child for the node currently
    // at pos
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    // Method 4
    // Returning true if the passed
    // node is a leaf node
    private boolean isLeaf(int pos)
    {

        return pos > (size / 2) && pos <= size;

    }

    // Method 5
    // To swap two nodes of the heap
    private void swap(int fpos, int spos)
    {

        int tmp;
        tmp = heap[fpos];

        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    // This method is responsible for restoring the heap property to
    // the tree
    private void minHeapify(int pos)
    {

        // If the node is a non-leaf node and greater
        // than any of its children
        if (!isLeaf(pos)) {
            if (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {

                // Always swap with largest value

                // Swap with the left child and heapify
                // the left child
                if (heap[leftChild(pos)]
                        < heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }

                // Swap with the right child and heapify
                // the right child
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    // Method 7
    // To insert a node into the heap
    public void insert(int element)
    {

        if (size >= maxsize) {
            return;
        }

        heap[++size] = element;
        int current = size;

        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Method 8
    // To print the contents of the heap
    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {

            // Printing the parent and both childrens
            System.out.print(
                    " PARENT : " + heap[i]
                            + " LEFT CHILD : " + heap[2 * i]
                            + " RIGHT CHILD :" + heap[2 * i + 1]);

            // By here new line is required
            System.out.println();
        }
    }

    // Method 9
    // To remove and return the minimum
    // element from the heap
    public int remove()
    {

        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        minHeapify(FRONT);

        return popped;
    }

}

