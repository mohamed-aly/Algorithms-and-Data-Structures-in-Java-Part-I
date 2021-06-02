package com.ds.hashMap;

public class HashItem<K, V> {
    private K key;
    private V value;
    private HashItem<K, V> nextHashItem;

    public HashItem(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public HashItem<K, V> getNextHashItem() {
        return nextHashItem;
    }

    public void setNextHashItem(HashItem<K, V> nextHashItem) {
        this.nextHashItem = nextHashItem;
    }
}
