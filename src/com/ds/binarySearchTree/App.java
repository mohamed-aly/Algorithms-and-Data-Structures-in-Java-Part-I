package com.ds.binarySearchTree;

public class App {

    public static void main(String[] args) {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(11);
        tree.insert(-1);
        tree.insert(0);

        tree.traverse();

    }
}
