package com.ds.splayTree;

public class SplayTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;
    private int size;

    public int getSize() {
        return size;
    }

    @Override
    public void insert(T data) {
        Node<T> tempNode = this.root;
        Node<T> parent = null;

        while (tempNode != null) {
            parent = tempNode;
            if (data.compareTo(tempNode.getData()) < 0) {
                tempNode = tempNode.getLeftChild();
            } else {
                tempNode = tempNode.getRightChild();
            }
        }

        tempNode = new Node<>(data);
        tempNode.setParent(parent);

        if (parent == null) {
            this.root = tempNode;
        } else if (data.compareTo(parent.getData()) < 0) {
            parent.setLeftChild(tempNode);
        } else {
            parent.setRightChild(tempNode);
        }

        splay(tempNode);
        this.size++;
    }

    private void splay(Node<T> tempNode) {

    }

    @Override
    public Node<T> find(T data) {
        Node<T> tempNode = this.root;
        while (tempNode != null) {
            if (data.compareTo(tempNode.getData()) < 0) {
                tempNode = tempNode.getLeftChild();
            } else if (data.compareTo(tempNode.getData()) > 0) {
                tempNode = tempNode.getRightChild();
            } else {
                splay(tempNode);
                return tempNode;
            }
        }

        return null;
    }

    @Override
    public T getMin() {
        if (this.root != null)
            return getMin(this.root);
        return null;
    }

    private T getMin(Node<T> node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }

        return node.getData();
    }

    @Override
    public T getMax() {
        if (this.root != null)
            return getMax(this.root);

        return null;
    }

    private T getMax(Node<T> node) {
        if (node.getRightChild() != null) {
            return getMin(node.getRightChild());
        }

        return node.getData();
    }

    @Override
    public void traverse() {
        if (this.root != null) {
            inOrderTraversal(this.root);
        }
    }

    private void inOrderTraversal(Node<T> node) {
        if (node.getLeftChild() != null)
            inOrderTraversal(node.getLeftChild());

        System.out.println(node + "  ");

        if (node.getRightChild() != null)
            inOrderTraversal(node.getRightChild());
    }
}
