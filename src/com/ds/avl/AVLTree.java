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
            System.out.println("new Data " + data + " < Node.getData() " + node.getData() + " Going left");
            node.setLeftChild(insert(node.getLeftChild(), data));
        } else {
            System.out.println("new Data " + data + " >= Node.getData() " + node.getData() + " Going right");
            node.setRightChild(insert(node.getRightChild(), data));
        }

        node.setHeight(Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())) + 1);

        node = settleViolation(node, data);

        return node;
    }

    private Node<T> settleViolation(Node<T> node, T data) {
        int balance = getBalance(node);
        System.out.println("Settling Violation and balance is = " + balance);
        //case 1 (double left heavy situation) left-left
        if (balance > 1 && data.compareTo(node.getLeftChild().getData()) < 0) {
            System.out.println("left-left");
            return rotateRight(node);
        }

        //case 2 (double right heavy situation) right-right
        if (balance < -1 && data.compareTo(node.getRightChild().getData()) > 0) {
            System.out.println("right-right");
            return rotateLeft(node);
        }

        //case 3 left-right
        if (balance > 1 && data.compareTo(node.getLeftChild().getData()) > 0) {
            System.out.println("left-right");
            node.setLeftChild(rotateLeft(node.getLeftChild()));
            return rotateRight(node);
        }

        //case 4 right-left
        if (balance < -1 && data.compareTo(node.getRightChild().getData()) < 0) {
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

        node.setHeight(Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())) + 1);
        newRoot.setHeight(Math.max(getHeight(newRoot.getLeftChild()), getHeight(newRoot.getRightChild())) + 1);

        return newRoot;
    }

    private Node<T> rotateLeft(Node<T> node) {
        System.out.println("Rotating left");
        Node<T> newRoot = node.getRightChild();
        Node<T> t = newRoot.getLeftChild();

        newRoot.setLeftChild(node);
        node.setRightChild(t);

        node.setHeight(Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())) + 1);
        newRoot.setHeight(Math.max(getHeight(newRoot.getLeftChild()), getHeight(newRoot.getRightChild())) + 1);


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

    @Override
    public void remove(T data) {
        if (this.root != null) {
            this.root = remove(this.root, data);
        }

        traverse();
    }

    private Node<T> remove(Node<T> node, T data) {

        if (node == null) {
            return null;
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(remove(node.getLeftChild(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(remove(node.getRightChild(), data));
        } else {
            //we found the node
            //case 1: leaf node
            if (node.getLeftChild() == null && node.getRightChild() == null) {
                return null;
            }

            //case 2: has a single child
            //left child
            if (node.getRightChild() == null) {
                Node<T> tempNode = node.getLeftChild();
                node = null;
                return tempNode;

                //right child
            } else if (node.getLeftChild() == null) {
                Node<T> tempNode = node.getRightChild();
                node = null;
                return tempNode;
            }

            //case 3: has 2 children
            Node<T> tempNode = getPredecessor(node.getLeftChild());
            //swap the data
            node.setData(tempNode.getData());
            //remove the old predecessor
            tempNode = remove(tempNode, data);

        }

        node.setHeight(Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())) + 1);

        node = settleDeletion(node);

        return node;
    }

    private Node<T> settleDeletion(Node<T> node) {
        int balance = getBalance(node);
        //left heavy
        if (balance > 1) {
            //check if left right
            if (getBalance(node.getLeftChild()) < 0) {
                node.setLeftChild(rotateLeft(node.getLeftChild()));
            }

            return rotateRight(node);
        }

        if (balance < -1) {
            //check if left right
            if (getBalance(node.getRightChild()) > 0) {
                node.setRightChild(rotateRight(node.getRightChild()));
            }

            return rotateLeft(node);
        }

        return node;

    }

    private Node<T> getPredecessor(Node<T> node) {
        if (node.getRightChild() != null) {
            return getPredecessor(node.getRightChild());
        }

        return node;
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
