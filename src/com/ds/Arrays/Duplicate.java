package com.ds.Arrays;

public class Duplicate {
    /*
    The problem is that we want to find duplicates in a T[] one-dimensional array of integers in O(N) running time
    where the integer values are smaller than the length of the array!
     */
    public static void main(String[] args) {
        int[] array = {0, 1, 3, 4, 5, 1, 2};
        System.out.println(hasDuplicates(array));
    }

    public static boolean hasDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = Math.abs(array[i]);
            if(array[index]>=0){
                array[index] = -array[index];
            }else{
                return true;
            }
        }
        return false;
    }
}
