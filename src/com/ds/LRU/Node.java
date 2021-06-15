package com.ds.LRU;

public class Node<T> {
    private int id;
    private T data;
    private Node<T> nextNode;
    private Node<T> previousNode;

    public Node(int id, T data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public Node<T> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node<T> previousNode) {
        this.previousNode = previousNode;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
