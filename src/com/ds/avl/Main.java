package com.ds.avl;

public class Main {

    public static void main(String[] args) {
        Tree<Integer> tree = new AVLTree<>();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);


        tree.traverse();
    }
}
