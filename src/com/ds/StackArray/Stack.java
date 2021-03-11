package com.ds.StackArray;

public class Stack<T> {
    private T[] stack;
    private int numberOfItems;

    public Stack() {
        this.stack = (T[]) new Object[1];
    }

    //O(N)
    public void push(T data) {
        if (this.stack.length == numberOfItems) {
            resize(2 * this.stack.length);
        }

        this.stack[numberOfItems++] = data;
    }

    //O(N)
    public T pop() {

        T itemToPop = this.stack[--numberOfItems];

        if (numberOfItems > 0 && numberOfItems == stack.length / 4) {
            resize(this.stack.length / 2);
        }

        return itemToPop;
    }

    //O(1)
    public T peek() {
        return this.stack[this.stack.length - 1];
    }

    //O(N)
    private void resize(int capacity) {
        T[] stackCopy = (T[]) new Object[capacity];
        for (int i = 0; i < this.numberOfItems; i++) {
            stackCopy[i] = this.stack[i];
        }
        this.stack = stackCopy;
    }

    //O(1)
    public boolean isEmpty(){
        return this.numberOfItems==0;
    }

    //O(1)
    public int size(){
        return numberOfItems;
    }
}
