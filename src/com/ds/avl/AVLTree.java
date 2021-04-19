package com.ds.avl;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    @Override
    public void insert(T data) {

    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> newRoot = node.getLeftChild();
        Node<T> t = newRoot.getRightChild();

        newRoot.setRightChild(node);
        node.setLeftChild(t);

        newRoot.setHeight(Math.max(getHeight(newRoot.getLeftChild()), getHeight(newRoot.getRightChild())) + 1);
        node.setHeight(Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())) + 1);

        return newRoot;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> newRoot = node.getRightChild();
        Node<T> t = newRoot.getLeftChild();

        newRoot.setLeftChild(node);
        node.setRightChild(t);

        newRoot.setHeight(Math.max(getHeight(newRoot.getLeftChild()), getHeight(newRoot.getRightChild())) + 1);
        node.setHeight(Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())) + 1);

        return newRoot;
    }

    private int getHeight(Node<T> node) {
        if (node == null) {
            return -1;
        }

        return node.getHeight();
    }

    private int getBalance(Node<T> node) {
        if (node == null) {
            return 0;
        }

        return getHeight(node.getLeftChild()) - getHeight(node.getRightChild());
    }

    @Override
    public void traverse() {
        inOrderTraversal(this.root);
    }

    private void inOrderTraversal(Node<T> node) {
        if (node.getLeftChild() != null) {
            inOrderTraversal(node.getLeftChild());
        }

        System.out.print(node + " ");

        if (node.getRightChild() != null) {
            inOrderTraversal(node.getRightChild());
        }
    }
}
