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

    private void fixViolations(Node<T> node) {
        Node<T> parentNode;
        Node<T> grandParentNode;

        while (node != root && node.getColor() != NodeColor.BLACK && node.getParent().getColor() == NodeColor.RED) {

            parentNode = node.getParent();
            grandParentNode = node.getParent().getParent();

            if (parentNode == grandParentNode.getLeftChild()) {

                Node<T> uncle = grandParentNode.getRightChild();

                //case 1: recoloring
                if (uncle != null && uncle.getColor() == NodeColor.RED) {
                    grandParentNode.setColor(NodeColor.RED);
                    parentNode.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    node = grandParentNode;
                } else {

                    if (node == parentNode.getRightChild()) {
                        leftRotate(parentNode);
                        node = parentNode;
                        parentNode = node.getParent();
                    }

                    rightRotate(grandParentNode);
                    System.out.println("Recoroling " + parentNode + " + " + grandParentNode);
                    NodeColor tempColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());
                    grandParentNode.setColor(tempColor);
                    node = parentNode;
                }
            } else {

                Node<T> uncle = grandParentNode.getLeftChild();

                if (uncle != null && uncle.getColor() == NodeColor.RED) {
                    grandParentNode.setColor(NodeColor.RED);
                    parentNode.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    node = grandParentNode;
                } else {

                    if (node == parentNode.getLeftChild()) {
                        rightRotate(parentNode);
                        node = parentNode;
                        parentNode = node.getParent();
                    }
                    leftRotate(grandParentNode);
                    System.out.println("Recoroling " + parentNode + " + " + grandParentNode);
                    NodeColor tempColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());
                    grandParentNode.setColor(tempColor);
                    node = parentNode;
                }
            }
        }

        if (root.getColor() == NodeColor.RED) {
            System.out.println("Recoloring the root to black...");
            root.setColor(NodeColor.BLACK);
        }

    }

    private void rightRotate(Node<T> node) {
        System.out.println("Rotate right on node " + node);

        //the left child will be the parent
        Node<T> leftChild = node.getLeftChild();

        //handle the right child of the leftChild
        node.setLeftChild(leftChild.getRightChild());
        if (node.getLeftChild() != null)
            node.getLeftChild().setParent(node);

        //inherit his new parent
        leftChild.setParent(node.getParent());
        if (node.getParent() == null)
            this.root = leftChild;
        else if (node == node.getParent().getLeftChild())
            node.getParent().setLeftChild(leftChild);
        else
            node.getParent().setRightChild(leftChild);

        //the new relation
        leftChild.setRightChild(node);
        node.setParent(leftChild);
    }

    private void leftRotate(Node<T> node) {
        System.out.println("Rotate left on node " + node);

        //the right child will be the parent
        Node<T> tempRightNode = node.getRightChild();

        //handle the left child of the rightChild
        node.setRightChild(tempRightNode.getLeftChild());
        if (node.getRightChild() != null)
            node.getRightChild().setParent(node);

        //inherit his new parent
        tempRightNode.setParent(node.getParent());
        if (tempRightNode.getParent() == null)
            root = tempRightNode;
        else if (node == node.getParent().getLeftChild())
            node.getParent().setLeftChild(tempRightNode);
        else
            node.getParent().setRightChild(tempRightNode);

        //the new relation
        tempRightNode.setLeftChild(node);
        node.setParent(tempRightNode);
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
