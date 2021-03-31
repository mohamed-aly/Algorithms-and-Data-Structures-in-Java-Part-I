package com.ds.binarySearchTree;

public class App {

    public static void main(String[] args) {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(11);
        tree.insert(-1);
        tree.insert(20);
        tree.insert(-5);
        tree.insert(0);

        tree.remove(20);
        System.out.println(tree.getMax());
        tree.remove(11);
        System.out.println(tree.getMax());
        tree.remove(10);
        System.out.println(tree.getMax());

        tree.traverse();

    }
}
