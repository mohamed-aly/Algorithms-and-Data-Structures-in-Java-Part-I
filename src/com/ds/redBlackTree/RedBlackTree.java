package com.ds.redBlackTree;

public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void traverse() {
        if (this.root != null)
            inOrderTraversal(this.root);
    }

    private void inOrderTraversal(Node<T> node) {
        if (node.getLeftChild() != null)
            inOrderTraversal(node.getLeftChild());

        System.out.print(node + "  ");

        if (node.getRightChild() != null)
            inOrderTraversal(node.getRightChild());
    }

    @Override
    public void insert(T data) {

        Node<T> newNode = new Node<>(data);
        this.root = insert(this.root, newNode);

        fixViolations(newNode);
    }

    private void fixViolations(Node<T> newNode) {

    }

    private Node<T> insert(Node<T> root, Node<T> newNode) {

        if (root == null) {
            return newNode;
        }

        if (newNode.getData().compareTo(root.getData()) < 0) {
            root.setLeftChild(insert(root.getLeftChild(), newNode));
            root.getLeftChild().setParent(root);
        } else {
            root.setRightChild(insert(root.getRightChild(), newNode));
            root.getRightChild().setParent(root);
        }

        return root;

    }
}
