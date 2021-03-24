package com.ds.binarySearchTree;

public interface Tree<T> {

    void traverse();
    void insert(T data);
    void remove(T data);
    T getMin();
    T getMax();
}
