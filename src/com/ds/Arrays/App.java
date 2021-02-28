package com.ds.Arrays;

public class App {
    public static void main(String[] args) {

        int[] nums = new int[5];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        //O(1)
        //get specific element
        System.out.println(nums[2]);


        //O(N) linear time complexity --> O(logN) binary tress --> O(1) hashTables
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 4){
                System.out.println("number 4 is found");
            }
        }
    }
}
