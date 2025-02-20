package com.example.demo.java.collections;

import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeapQueue = new PriorityQueue<>(); //By default, PriorityQueue is a min-heap
        //or with comparator
        //PriorityQueue<Integer> maxHeapQueue = new PriorityQueue<>((Integer a, Integer b) -> a-b);

//        Insertion in Min-Heap:

//        1. Insert the new element at the leftmost available position to maintain the complete binary tree structure.
//        2. Heapify Up: Compare the new element with its parent and swap if necessary. Repeat until the heap property is restored (new element is no longer smaller than its parent).
//                Time Complexity:

//        O(log n) due to the heapify-up process.
        minHeapQueue.add(10);
        minHeapQueue.add(5);
        minHeapQueue.add(20);
        minHeapQueue.add(1);

        System.out.println(minHeapQueue);

        //        Deletion (Remove Min) in Min-Heap:
//        1. Remove the root (smallest element).
//        2. Replace the root with the last element in the heap.
//        3. Heapify Down: Compare the new root with its children and swap with the smaller child if necessary. Repeat until the heap property is restored.
//                Time Complexity:
//        O(log n) due to the heapify-down process.

        minHeapQueue.remove(1);

        System.out.println(minHeapQueue);

/*### **Insertion in Max-Heap**:
        1. **Insert** the new element at the next available position (leftmost in the last level).
        2. **Heapify Up**: Compare with the parent and swap if larger, repeating until the heap property is restored.

**Time Complexity**: `O(log n)` (due to heapify-up).

        ---

### **Deletion (Remove Max) in Max-Heap**:
        1. **Remove the root** (largest element).
        2. **Replace root** with the last element.
        3. **Heapify Down**: Compare with children and swap with the larger one, repeating until the heap property is restored.

**Time Complexity**: `O(log n)` (due to heapify-down).*/

        //By default, PriorityQueue is a min-heap
        // for maxheap we need to provide comparator in the arguments
        PriorityQueue<Integer> maxHeapQueue = new PriorityQueue<>((Integer a, Integer b) -> b - a);

        maxHeapQueue.add(10);
        maxHeapQueue.add(5);
        maxHeapQueue.add(20);
        maxHeapQueue.add(1);

        System.out.println(maxHeapQueue);


    }
}
