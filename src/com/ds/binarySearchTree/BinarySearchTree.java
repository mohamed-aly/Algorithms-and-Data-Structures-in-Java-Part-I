package com.ds.binarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void traverse() {
        if (this.root != null)
            inOrderTraversal(this.root);
    }

    private void inOrderTraversal(Node<T> node) {
        if (node.getLeftChild() != null)
            inOrderTraversal(node.getLeftChild());

        System.out.print(node + " -- ");

        if (node.getRightChild() != null)
            inOrderTraversal(node.getRightChild());
    }

    @Override
    public void insert(T data) {
        if (this.root == null) {
            this.root = new Node<>(data);
        } else {
            insertNode(this.root, data);
        }
    }

    private void insertNode(Node<T> node, T newData) {
        if (newData.compareTo(node.getData()) < 0) {
            if (node.getLeftChild() != null) {
                insertNode(node.getLeftChild(), newData);
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setLeftChild(newNode);
            }
        } else {
            if (node.getRightChild() != null) {
                insertNode(node.getRightChild(), newData);
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setRightChild(newNode);
            }
        }
    }

    @Override
    public void remove(T data) {

    }

    @Override
    public T getMin() {
        if (this.root == null) {
            return null;
        }

        return getMin(root.getLeftChild());

    }

    private T getMin(Node<T> node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }

        return node.getData();

    }

    @Override
    public T getMax() {
        if (this.root == null) {
            return null;
        }
        return getMax(this.root.getRightChild());

    }

    private T getMax(Node<T> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }

        return node.getData();

    }
}
