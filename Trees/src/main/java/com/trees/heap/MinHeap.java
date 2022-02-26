package com.trees.heap;

public class MinHeap {

    private int[] heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    public MinHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.heap = new int[maxsize + 1];
        this.size = 0;
        heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return 2 * pos;
    }

    private int rightChild(int pos)
    {
        return 2 * pos + 1;
    }

    private boolean isLeaf(int pos)
    {
        // Can alternatively do if you're in the last half
        return leftChild(pos) > size || rightChild(pos) > size ;
    }

    private void swap(int fpos, int spos)
    {
        int temp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = temp;
    }

    // This goes from the position and makes sure everything is in order
    private void minHeapify(int pos)
    {
        if(!isLeaf(pos)) {
            if(heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
                if(heap[leftChild(pos)] > heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element)
    {
        if(size >= maxsize) {
            return;
        }
        size++;
        heap[size] = element;

        int currentPosition = size;

        while(currentPosition < parent(currentPosition)) {
            swap(currentPosition, parent(currentPosition));
            currentPosition = parent(currentPosition);
        }
    }

    // Method 8
    // To print the contents of the heap
    public void print()
    {
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

