package com.ds.binarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    private static int count = 0;


    @Override
    public boolean isTypical(Tree<T> tree) {
        if (this.root != null) {
            return isTypical(this.root, tree.getRoot());
        }
        return false;
    }

    private boolean isTypical(Node<T> node1, Node<T> node2) {
        if (node1 == null || node2 == null) return node1 == node2;

        if (node1.getData().compareTo(node2.getData()) != 0) {
            return false;
        }

        return isTypical(node1.getLeftChild(), node2.getLeftChild()) && isTypical(node2.getRightChild(), node2.getRightChild());
    }

    @Override
    public Node<T> getRoot() {
        return this.root;
    }


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

        return getMin(root);

    }

    private T getMin(Node<T> node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
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

    @Override
    public Node<T> smallestK(int order) {
        return getSmallestK(this.root, order);
    }

    private Node<T> getSmallestK(Node<T> node, int k) {
        int n = treeSize(node.getLeftChild()) + 1;

        if (n == k) return node;
        if (n > k) return getSmallestK(node.getLeftChild(), k);
        else return getSmallestK(node.getRightChild(), k-n);
    }

    private int treeSize(Node<T> node) {
        if (node == null) return 0;

        return (treeSize(node.getLeftChild()) + treeSize(node.getRightChild()) + 1);
    }


    private T getMax(Node<T> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }

        return node.getData();

    }
}
