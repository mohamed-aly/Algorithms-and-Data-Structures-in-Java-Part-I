package com.ds.HashTableInterviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class SummingTwoIntegers {
    private int[] array;
    private int s;
    private Map<Integer, Integer> hashTable;

    public SummingTwoIntegers(int[] array, int s) {
        this.array = array;
        this.s = s;
        this.hashTable = new HashMap<>();
    }

    public void solve() {
        //int[] array = {3,5,2,-4,8,11};
        for (int i = 0; i < array.length; i++) {
            int remainder = this.s - array[i];

            if (this.hashTable.containsValue(remainder))
                System.out.println("Solution: " + array[i] + " + " + remainder + " = " + s);

            this.hashTable.put(i, array[i]);
        }
    }
}
