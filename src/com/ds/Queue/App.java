package com.ds.Queue;

public class App {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        System.out.println(queue.isEmpty());
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
    }
}
