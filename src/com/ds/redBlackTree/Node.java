package com.ds.redBlackTree;

public class Node<T> {
    private T data;
    private NodeColor color;
    private Node<T> leftChild;
    private Node<T> rightChild;
    private Node<T> parentChild;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeColor getColor() {
        return color;
    }

    public void setColor(NodeColor color) {
        this.color = color;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public Node<T> getParentChild() {
        return parentChild;
    }

    public void setParentChild(Node<T> parentChild) {
        this.parentChild = parentChild;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
