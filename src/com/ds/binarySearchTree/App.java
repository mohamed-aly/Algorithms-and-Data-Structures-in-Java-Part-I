package com.ds.binarySearchTree;

public class App {

    public static void main(String[] args) {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(11);

        Tree<Integer> tree2 = new BinarySearchTree<>();
        tree2.insert(10);
        tree2.insert(5);
        tree2.insert(1);

        System.out.println(tree.isTypical(tree2));


    }
}
