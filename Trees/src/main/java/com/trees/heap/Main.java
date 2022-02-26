package com.trees.heap;

public class Main {

    public static void main(String[] arg)
    {

        // Display message
        System.out.println("The Min Heap is ");

        // Creating object opf class in main() methodn
        MinHeapPrevious minHeap = new MinHeapPrevious(15);

        // Inserting element to minHeap
        // using insert() method

        // Custom input entries
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        // Print all elements of the heap
        minHeap.print();

        // Removing minimum value from above heap
        // and printing it
        System.out.println("The Min val is "
                + minHeap.remove());
    }

}
