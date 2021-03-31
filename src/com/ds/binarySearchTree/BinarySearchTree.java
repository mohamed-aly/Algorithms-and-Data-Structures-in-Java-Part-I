package com.ds.binarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void traverse() {
        if (this.root != null)
            inOrderTraversal(this.root);
    }

    private void inOrderTraversal(Node<T> node) {
        if (node.getLeftChild() != null)
            inOrderTraversal(node.getLeftChild());

        System.out.print(node + " -- ");

        if (node.getRightChild() != null)
            inOrderTraversal(node.getRightChild());
    }

    @Override
    public void insert(T data) {
        if (this.root == null) {
            this.root = new Node<>(data);
        } else {
            insertNode(this.root, data);
        }
    }

    private void insertNode(Node<T> node, T newData) {
        if (newData.compareTo(node.getData()) < 0) {
            if (node.getLeftChild() != null) {
                insertNode(node.getLeftChild(), newData);
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setLeftChild(newNode);
            }
        } else {
            if (node.getRightChild() != null) {
                insertNode(node.getRightChild(), newData);
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setRightChild(newNode);
            }
        }
    }

    @Override
    public void remove(T data) {
        if (this.root != null)
            this.root = remove(this.root, data);

    }

    private Node<T> remove(Node<T> node, T data) {
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(remove(node.getLeftChild(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(remove(node.getRightChild(), data));
        } else {
            //we found the node

            //first case: leaf node
            if (node.getLeftChild() == null && node.getRightChild() == null) {
                return null;
            }

            //second case: has a single child
            //1- has left child
            if (node.getRightChild() == null) {
                Node<T> tempNode = node.getLeftChild();
                node = null;
                return tempNode;
                //2- has right child
            } else if (node.getLeftChild() == null) {
                Node<T> tempNode = node.getRightChild();
                node = null;
                return tempNode;
            }

            //case three: node with 2 children
            Node<T> tempNode = getPredecessor(node.getLeftChild());
            //swap the data
            node.setData(tempNode.getData());
            node.setLeftChild(remove(tempNode.getLeftChild(), data));
        }

        return node;
    }

    private Node<T> getPredecessor(Node<T> node) {
        if (node.getRightChild() != null) {
            return getPredecessor(node.getRightChild());
        }

        return node;
    }

    @Override
    public T getMin() {
        if (this.root == null) {
            return null;
        }

        return getMin(root.getLeftChild());

    }

    private T getMin(Node<T> node) {
        if (node.getLeftChild() != null) {
            return getMin(node);
        }

        return node.getData();

    }

    @Override
    public T getMax() {
        if (this.root == null) {
            return null;
        }
        return getMax(this.root);

    }

    private T getMax(Node<T> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }

        return node.getData();

    }
}
