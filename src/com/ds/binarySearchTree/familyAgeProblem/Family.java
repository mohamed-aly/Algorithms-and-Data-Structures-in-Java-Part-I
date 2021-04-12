package com.ds.binarySearchTree.familyAgeProblem;

import com.ds.binarySearchTree.BinarySearchTree;
import com.ds.binarySearchTree.Node;
import com.ds.binarySearchTree.Tree;

public class Family {
    private Tree<Person> members;

    public Family() {
        this.members = new BinarySearchTree<>();
    }

    public void addMember(Person person) {
        this.members.insert(person);
    }

    public int agesSum() {
        return agesSum(members.getRoot());
    }

    private int agesSum(Node<Person> node) {
        if (node == null) return 0;
        int leftSum = agesSum(node.getLeftChild());
        int rightSum = agesSum(node.getRightChild());
        return node.getData().getAge() + leftSum + rightSum;
    }
}
