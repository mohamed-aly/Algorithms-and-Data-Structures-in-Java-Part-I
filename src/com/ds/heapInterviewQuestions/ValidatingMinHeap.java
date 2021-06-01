package com.ds.heapInterviewQuestions;

public class ValidatingMinHeap {
    public static void main(String[] args) {
        int[] array = {2, 5, 23, 210, 100};
        System.out.println(isValidMinHeap(array));
    }

    private static boolean isValidMinHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int leftChildIndex = (i * 2) + 1;
            int rightChildIndex = (i * 2) + 2;
            if (leftChildIndex < array.length && array[i] > array[leftChildIndex]) {
                return false;
            } else if (rightChildIndex < array.length && array[i] > array[rightChildIndex]) {
                return false;
            }
        }

        return true;

    }
}
