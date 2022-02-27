package com.trees.heap;

public class MinHeap {

    int[] heap;
    int maxSize;
    int size;

    private final int FRONT = 1;

    public MinHeap(int maxsize)
    {
        this.maxSize = maxsize;
        this.heap = new int[maxSize + 1];
        size = 0;

        heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private void swap(int currentPosition, int parent) {
        int temp = heap[currentPosition];
        heap[currentPosition] = heap[parent];
        heap[parent] = temp;
    }

    private void minHeapify(int pos) {
        if(!isLeafNode(pos)) {
            if(heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
                // Always want to go to the minimum
                if(heap[leftChild(pos)] < heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    private int rightChild(int pos) {
        return 2 * pos + 1;
    }

    private int leftChild(int pos) {
        return 2 * pos;
    }

    private boolean isLeafNode(int pos) {
        return pos > size / 2 && pos <= size;
    }

    public void insert(int element)
    {
        if(size >= maxSize) {
            return;
        }

        size++;
        heap[size] = element;

        int currentPosition = size;

        while(heap[currentPosition] < heap[parent(currentPosition)]) {
            swap(currentPosition, parent(currentPosition));
            currentPosition = parent(currentPosition);
        }
    }

    public int remove()
    {
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        minHeapify(FRONT);
        return popped;
    }

}

