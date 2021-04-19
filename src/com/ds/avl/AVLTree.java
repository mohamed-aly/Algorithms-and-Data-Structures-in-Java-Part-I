package com.ds.avl;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    @Override
    public void insert(T data) {

    }

    private int getHeight(Node<T> node){
        if(node == null){
            return -1;
        }

        return node.getHeight();
    }

    private int getBalance(Node<T> node){
        if(node == null){
            return 0;
        }

        return getHeight(node.getLeftChild()) - getHeight(node.getRightChild());
    }

    @Override
    public void traverse() {
        inOrderTraversal(this.root);
    }

    private void inOrderTraversal(Node<T> node) {
        if (node.getLeftChild() != null) {
            inOrderTraversal(node.getLeftChild());
        }

        System.out.print(node + " ");

        if(node.getRightChild() != null){
            inOrderTraversal(node.getRightChild());
        }
    }
}
