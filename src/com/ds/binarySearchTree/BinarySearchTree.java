package com.ds.binarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void traverse() {

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
        if (node.getData().compareTo(newData) < 0) {
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
        return null;
    }

    @Override
    public T getMax() {
        return null;
    }
}
