import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        int numberQueries = args[0]
        
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
        
        MinIntHeap(int heapSize) {
            int[] items = items[heapSize];
        }
        
        public int getLeftChildIndex(int parentIndex) {
            return 2 * parentIndex + 1;
        }
        
        public int getLeftChildIndex(int parentIndex) {
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
        
        public int leftChild(index) {
            return items[getLeftChild(index)];
        }
        
        public int rightChild(index) {
            return items[getRightChild(index)];
        }
        
        public int parent(index) {
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
            int index = size() - 1;
            while(hasParent(index) && parent(index) > items[index]) {
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }
        
        public void heapifyDown() {
            
        }
    }
}