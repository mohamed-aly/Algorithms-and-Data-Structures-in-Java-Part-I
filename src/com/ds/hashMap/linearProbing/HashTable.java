package com.ds.hashMap.linearProbing;


public class HashTable<K, V> {
    private HashItem<K, V>[] hashTable;

    public HashTable() {
        this.hashTable = new HashItem[Constants.TABLE_SIZE];
    }

    public V get(K key) {
        int hashArrayIndex = hash(key);

        while (this.hashTable[hashArrayIndex] != null && !this.hashTable[hashArrayIndex].getKey().equals(key)) {
            hashArrayIndex = (hashArrayIndex + 1) % Constants.TABLE_SIZE;
        }

        if(this.hashTable[hashArrayIndex] == null){
            throw new IllegalArgumentException("No Records found with this Key");
        }

        return this.hashTable[hashArrayIndex].getValue();
    }

    public void put(K key, V value) {
        int hashArrayIndex = hash(key);

        while (this.hashTable[hashArrayIndex] != null) {
            hashArrayIndex = (hashArrayIndex + 1) % Constants.TABLE_SIZE;
        }

        this.hashTable[hashArrayIndex] = new HashItem<>(key, value);
    }

    private int hash(K key) {
        return key.hashCode() % Constants.TABLE_SIZE;
    }


}
