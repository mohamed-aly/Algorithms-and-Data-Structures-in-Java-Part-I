package com.ds.HashTableInterviewQuestions;

public class App {
    public static void main(String[] args) {
        int[] array = {3,5,2,-4,8,11};
        int sum = 7;
        SummingTwoIntegers summingTwoIntegers = new SummingTwoIntegers(array, sum);
        summingTwoIntegers.solve();
    }
}
