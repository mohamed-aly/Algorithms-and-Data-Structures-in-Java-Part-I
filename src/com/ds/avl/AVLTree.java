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
        this.root = insert(this.root, data);

    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            System.out.println(data + " inserted");
            return new Node<>(data);
        }

        if (data.compareTo(node.getData()) < 0) {
            System.out.println("new Data " + data +" < Node.getData() " + node.getData() + " Going left");
            node.setLeftChild(insert(node.getLeftChild(), data));
        } else {
            System.out.println("new Data " + data +" >= Node.getData() " + node.getData()+ " Going right");
            node.setRightChild(insert(node.getRightChild(), data));
        }

        node.setHeight(Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())) + 1);
//        System.out.println(this.root.getHeight());

        node = settleViolation(node, data);

        return node;
    }

    private Node<T> settleViolation(Node<T> node, T data) {
        int balance = getBalance(node);
        System.out.println("Settling Violation and balance is = " + balance);
        //case 1 (double left heavy situation) left-left
        if(balance > 1 && data.compareTo(node.getLeftChild().getData()) < 0){
            System.out.println("left-left");
            return rotateRight(node);
        }

        //case 2 (double right heavy situation) right-right
        if(balance < -1 && data.compareTo(node.getRightChild().getData()) > 0){
            System.out.println("right-right");
            return rotateLeft(node);
        }

        //case 3 left-right
        if(balance > 1 && data.compareTo(node.getLeftChild().getData()) > 0){
            System.out.println("left-right");
            node.setLeftChild(rotateLeft(node.getLeftChild()));
            return rotateRight(node);
        }

        //case 4 right-left
        if(balance < -1 && data.compareTo(node.getRightChild().getData()) < 0){
            System.out.println("right-left");
            node.setRightChild(rotateRight(node.getRightChild()));
            return rotateLeft(node);
        }

        return node;
    }

    private Node<T> rotateRight(Node<T> node) {
        System.out.println("Rotating Right");
        Node<T> newRoot = node.getLeftChild();
        Node<T> t = newRoot.getRightChild();

        newRoot.setRightChild(node);
        node.setLeftChild(t);

        newRoot.setHeight(Math.max(getHeight(newRoot.getLeftChild()), getHeight(newRoot.getRightChild())) + 1);
        node.setHeight(Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())) + 1);

        return newRoot;
    }

    private Node<T> rotateLeft(Node<T> node) {
        System.out.println("Rotating left");
        Node<T> newRoot = node.getRightChild();
        Node<T> t = newRoot.getLeftChild();

        newRoot.setLeftChild(node);
        node.setRightChild(t);

        newRoot.setHeight(Math.max(getHeight(newRoot.getLeftChild()), getHeight(newRoot.getRightChild())) + 1);
        node.setHeight(Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())) + 1);

        return newRoot;
    }

    private int getHeight(Node<T> node) {
        if (node == null) {
            return -1;
        }

        return node.getHeight();
    }

    private int getBalance(Node<T> node) {
        if (node == null) {
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

        if (node.getRightChild() != null) {
            inOrderTraversal(node.getRightChild());
        }
    }
}
