package com.ds.hashMap.linearProbing;


public class HashTable<K, V> {
    private HashItem<K, V>[] hashTable;

    public HashTable() {
        this.hashTable = new HashItem[Constants.TABLE_SIZE];
    }

    public V get(K key) {
        int hashArrayIndex = hash(key);
        HashItem<K, V> hashItem = this.hashTable[hashArrayIndex];

        if (hashItem == null) {
            throw new IllegalArgumentException("No Records Found with the provided Key");
        } else {

            while (hashItem != null && !hashItem.getKey().equals(key)) {
                hashItem = this.hashTable[++hashArrayIndex];
            }

            if (hashItem == null) {
                throw new IllegalArgumentException("No Records Found with the provided Key");
            }

            return hashItem.getValue();
        }
    }

    public void put(K key, V value) {
        int hashArrayIndex = hash(key);

        while(this.hashTable[hashArrayIndex] != null){
            hashArrayIndex = (hashArrayIndex+1)%Constants.TABLE_SIZE;
        }

        this.hashTable[hashArrayIndex] = new HashItem<>(key, value);
    }

    private int hash(K key) {
        return key.hashCode() % Constants.TABLE_SIZE;
    }


}
