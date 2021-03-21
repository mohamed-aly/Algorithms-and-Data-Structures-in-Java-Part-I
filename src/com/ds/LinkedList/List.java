package com.ds.LinkedList;

public interface List<T extends Comparable<T>> {

    void add(T data);

    void remove(T data);

    void traverse();

    int size();

    Node<T> getMiddleNode();

    void reverse();
}
