package com.ds.avl;

public class Main {

    public static void main(String[] args) {
        Tree<Integer> tree = new AVLTree<>();

        tree.insert(2);
        tree.insert(1);
        tree.insert(5);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        tree.insert(10);

        tree.remove(1);
        tree.remove(4);
    }
}
