package com.ds.avl;

public interface Tree<T extends Comparable<T>> {
    void insert(T data);
    void traverse();
    void remove(T data);
}
