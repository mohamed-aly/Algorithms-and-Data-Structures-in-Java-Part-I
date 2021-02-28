package com.ds.Arrays;

public class InterView {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        reverse(array);
        print(array);
    }

    public static void reverse(int[] array) {
        for (int i = 0; i <= array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public static void print(int[] array) {
        for (int i : array)
            System.out.print(i + " ");
    }
}
