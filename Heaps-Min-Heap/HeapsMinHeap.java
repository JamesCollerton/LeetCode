import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        for(String arg: args) {
            System.out.println(arg);    
        }
        
        int numberQueries = Integer.parseInt(args[0]);
        
        if(numberQueries == 0) {
            return;
        }
        
        MinIntHeap minIntHeap = new MinIntHeap(numberQueries);
        
        for(int i = 1; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
    
    private class MinIntHeap {
        
        int[] items;
        private int size = 0;
        
        MinIntHeap(int heapSize) {
            int[] items = new int[heapSize];
        }
        
        public int getLeftChildIndex(int parentIndex) {
            return 2 * parentIndex + 1;
        }
        
        public int getRightChildIndex(int parentIndex) {
            return 2 * parentIndex + 2;
        }
        
        public int getParentIndex(int childIndex) {
            return (childIndex - 1) / 2;
        }
        
        public boolean hasLeftChild(int index) {
            return getLeftChildIndex(index) < size;
        }
        
        public boolean hasRightChild(int index) {
            return getRightChildIndex(index) < size;
        }
        
        public boolean hasParent(int index) {
            return getParentIndex(index) >= 0;
        }
        
        public int leftChild(int index) {
            return items[getLeftChildIndex(index)];
        }
        
        public int rightChild(int index) {
            return items[getRightChildIndex(index)];
        }
        
        public int parent(int index) {
            return items[getParentIndex(index)];
        }
        
        public void swap(int indexOne, int indexTwo) {
            int temp = items[indexOne];
            items[indexOne] = items[indexTwo];
            items[indexTwo] = temp;
        }
        
        public int peek() {
            if(size == 0) {
                throw new IllegalStateException();
            }
            return items[0];
        }
        
        public int poll() {
            if(size == 0) {
                throw new IllegalStateException();
            }
            int item = items[0];
            items[0] = items[size - 1];
            size--;
            heapifyDown();
            return item;
        }
        
        public void add(int item) {
            items[size] = item;
            size++;
            heapifyUp();
        }
        
        public void heapifyUp() {
            int index = size - 1;
            while(hasParent(index) && parent(index) > items[index]) {
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }
        
        public void heapifyDown() {
            int index = 0;
            while(hasLeftChild(index)) {
                int smallerChildIndex = getLeftChildIndex(index);
                if(hasRightChild(index) && rightChild(index) < leftChild(index)) {
                    smallerChildIndex = getRightChildIndex(index);
                }
                if(items[index] < items[smallerChildIndex]) {
                    break;
                } else {
                    swap(index, smallerChildIndex);
                }
                index = smallerChildIndex;
            }    
        }
    }
}