package com.ds.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<T> {
    private int size;
    private Map<Integer, Node<T>> map;
    private DoubleLinkedList<T> linkedList;

    public LRUCache() {
        this.map = new HashMap<>();
        this.linkedList = new DoubleLinkedList<>();
    }

    public void put(int id, T data) {
        if (this.map.containsKey(id)) {
            //update node;
            Node<T> node = this.map.get(id);
            node.setData(data);
            update(node);
        }

        //new node
        Node<T> newNode = new Node<>(id, data);
        add(newNode);

        //size
        if (this.size < Constants.CAPACITY) {
            this.size++;
        } else {
            removeTail();
        }

    }

    private void add(Node<T> newNode) {
        //update the new node references
        newNode.setNextNode(this.linkedList.getHeadNode());
        newNode.setPreviousNode(null);

        //update the previous head
        if (this.linkedList.getHeadNode() != null) {
            this.linkedList.getHeadNode().setPreviousNode(newNode);
        }

        //update the new head
        this.linkedList.setHeadNode(newNode);

        //the tail
        if (this.linkedList.getTailNode() == null) {
            this.linkedList.setTailNode(newNode);
        }

        this.map.put(newNode.getId(), newNode);

    }

    private void removeTail() {
        Node<T> tailNode = this.linkedList.getTailNode();

        //update the new tail
        this.linkedList.setTailNode(this.linkedList.getTailNode().getPreviousNode());

        if (tailNode != null) {
            this.linkedList.getTailNode().setNextNode(null);
        }

        tailNode = null;
    }

    public Node<T> get(int id) {
        if (!this.map.containsKey(id)) {
            return null;
        }

        Node<T> node = this.map.get(id);
        update(node);
        return node;
    }

    private void update(Node<T> node) {
        Node<T> previousNode = node.getPreviousNode();
        Node<T> nextNode = node.getNextNode();

        //update the references of the next and previous
        if (previousNode != null) {
            previousNode.setNextNode(nextNode);
        } else {
            this.linkedList.setHeadNode(nextNode);
        }

        if (nextNode != null) {
            nextNode.setPreviousNode(previousNode);
        } else {
            this.linkedList.setTailNode(previousNode);
        }

        add(node);
    }

    public void show() {
        Node<T> node = this.linkedList.getHeadNode();

        while (node != null) {
            System.out.println(node);
            node = node.getNextNode();
        }
    }

    public int getSize() {
        return size;
    }

    public Map<Integer, Node<T>> getMap() {
        return map;
    }

    public DoubleLinkedList<T> getLinkedList() {
        return linkedList;
    }
}
