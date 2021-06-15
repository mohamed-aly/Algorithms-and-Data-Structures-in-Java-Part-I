package com.ds.LRU;

public class DoubleLinkedList<T> {
    private Node<T> headNode;
    private Node<T> tailNode;

    public DoubleLinkedList() {
    }


    public Node<T> getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node<T> headNode) {
        this.headNode = headNode;
    }

    public Node<T> getTailNode() {
        return tailNode;
    }

    public void setTailNode(Node<T> tailNode) {
        this.tailNode = tailNode;
    }
}
