package com.ds.heapInterviewQuestions;

public class ValidatingMinHeap {
    public static void main(String[] args) {
        int[] array = {2, 5, 23, 210, 100, 1};
        System.out.println(isValidMinHeap(array));
    }

    private static boolean isValidMinHeap(int[] array) {
        for (int i = 0; i <= (array.length - 1) / 2; i++) {
            int leftChildIndex = (i * 2) + 1;
            int rightChildIndex = (i * 2) + 2;
            if (array[i] > array[leftChildIndex] || (rightChildIndex < array.length && array[i] > array[rightChildIndex])) {
                return false;
            }
        }

        return true;

    }
}
