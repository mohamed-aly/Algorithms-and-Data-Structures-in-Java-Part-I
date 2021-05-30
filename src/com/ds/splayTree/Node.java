package com.ds.splayTree;

public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> rightChild;
    private Node<T> leftChild;
    private Node<T> parent;

    public Node(T data) {
        this.data = data;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }


    @Override
    public String toString() {
        return data.toString();
    }
}
