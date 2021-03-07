package com.ds.LinkedList;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int size;

    @Override
    public void add(T data) {
        if (this.root == null) {
            this.root = new Node<>(data);
        } else {
            insertAtTheBeginning(data);
        }
        ++this.size;
    }

    private void insertAtTheBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(this.root);
        this.root = newNode;
    }

    private void insertAtTheEnd(T data, Node<T> node) {

        if (node.getNextNode() != null) {
            insertAtTheEnd(data, node.getNextNode());
        } else {
            Node<T> newNode = new Node<>(data);
            node.setNextNode(newNode);
        }

    }

    @Override
    public void remove(T data) {
        if (this.root == null) return;

        if (this.root.getData().compareTo(data) == 0) {
            this.root = this.root.getNextNode();
        } else {
            remove(data, this.root, this.root.getNextNode());
        }

        --this.size;

    }

    private void remove(T data, Node<T> previousNode, Node<T> actualNode) {
        while (actualNode != null) {
            if (actualNode.getData().compareTo(data) == 0) {
                previousNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                return;
            }

            previousNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public void traverse() {
        if (this.root == null) return;

        Node<T> actualNode = this.root;

        while (actualNode != null) {
            System.out.print(actualNode.getData() + " ");
            actualNode = actualNode.getNextNode();
        }
        System.out.println();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Node<T> getMiddleNode() {
        Node<T> fasterPointer = this.root;
        Node<T> slowerPointer = this.root;
        while (fasterPointer.getNextNode() != null && fasterPointer.getNextNode().getNextNode() != null) {
            fasterPointer = fasterPointer.getNextNode().getNextNode();
            slowerPointer = slowerPointer.getNextNode();
        }

        return slowerPointer;
    }
}
