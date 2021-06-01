package com.ds.heapInterviewQuestions;

public class MaxHeapIntoMinHeap {

    private int[] heap;

    public MaxHeapIntoMinHeap(int[] heap) {
        this.heap = heap;
    }

    public void transform() {
        for (int i = (this.heap.length - 1) / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int parentIndex) {
        int leftChildIndex = (parentIndex * 2) + 1;
        int rightChildIndex = (parentIndex * 2) + 2;

        int smallestIndex = parentIndex;

        if (leftChildIndex < this.heap.length && this.heap[leftChildIndex] < this.heap[smallestIndex]) {
            smallestIndex = leftChildIndex;
        }

        if (rightChildIndex < this.heap.length && this.heap[rightChildIndex] < this.heap[smallestIndex]) {
            smallestIndex = rightChildIndex;
        }

        if(smallestIndex != parentIndex){
            swap(smallestIndex, parentIndex);
            heapify(smallestIndex);
        }
    }

    private void swap(int smallestIndex, int parentIndex) {
        int temp = this.heap[smallestIndex];
        this.heap[smallestIndex] = this.heap[parentIndex];
        this.heap[parentIndex] = temp;
    }
}
