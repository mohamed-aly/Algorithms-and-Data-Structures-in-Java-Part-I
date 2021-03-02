package com.ds.Arrays;

import java.util.Random;

public class ReservoirSampling {
    /*
    Interview Question #4:

Our task is to design an algorithm thats capable of selecting k items from an array! The problem is that the n size of the
 array is unknown (or infinitely large)!

Solution: we can solve this problem with the so-called reservoir sampling algoirthm! Check it out!
     */
    public static void main(String[] args) {
        int[] array = {1, 55, 68, 93, 45, 14, 67, 1, 5, 75};
        solve(array, 5);
    }

    public static void solve(int[] array, int k) {

        Random random = new Random();

        int[] reservoir = new int[k];

        //arrayCopy
        System.arraycopy(array, 0, reservoir, 0, k);

        for (int i = k + 1; i < array.length; i++) {
            int j = random.nextInt(i);
            if (j < k) reservoir[j] = array[i];
        }

        for(int i : reservoir){
            System.out.print(i+" ");
        }

    }
}
