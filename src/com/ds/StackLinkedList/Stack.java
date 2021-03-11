package com.ds.StackLinkedList;

public class Stack<T extends Comparable<T>> {
    private Node<T> root;
    private int size;

    //O(1)
    public void push(T data) {
        if (this.root == null) {
            this.root = new Node<>(data);
        } else {
            Node<T> oldRoot = this.root;
            this.root = new Node<>(data);
            this.root.setNextNode(oldRoot);
        }

        ++this.size;
    }

    //O(1)
    public T pop() {
        T nodeToPop = this.root.getData();
        this.root = this.root.getNextNode();
        --this.size;
        return nodeToPop;
    }

    //O(1)
    public T peek() {
        return this.root.getData();
    }

    //O(1)
    public boolean isEmpty() {
        return this.root == null;
    }

    //O(1)
    public int size() {
        return this.size;
    }

}
