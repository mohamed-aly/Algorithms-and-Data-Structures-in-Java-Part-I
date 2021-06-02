package com.ds.hashMap.genericLinearProbing;

@SuppressWarnings("unchecked")
public class HashTable<K, V> {
    private K[] keys;
    private V[] values;
    private int size;
    private int capacity;

    public HashTable() {
        this.capacity = Constants.TABLE_SIZE;
        this.keys = (K[]) new Object[this.capacity];
        this.values = (V[]) new Object[this.capacity];
    }

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.keys = (K[]) new Object[capacity];
        this.values = (V[]) new Object[capacity];
    }

    //O(1)
    public int getSize() {
        return size;
    }

    //O(1)
    public boolean isEmpty() {
        return this.size == 0;
    }

    public V get(K key) {
        if (key == null) return null;

        int index = hash(key);

        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];
            } else {
                index = (index + 1) % this.capacity;
            }
        }

        return null;
    }

    public int hash(K key) {
        return key.hashCode() % this.capacity;
    }
}
