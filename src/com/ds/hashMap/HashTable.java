package com.ds.hashMap;

public class HashTable<K, V> {
    private HashItem<K, V>[] hashTable;

    public HashTable() {
        this.hashTable = new HashItem[Constants.TABLE_SIZE];
    }

    public V get(K key) {
        int hashArrayIndex = hash(key);
        HashItem<K, V> hashItem = this.hashTable[hashArrayIndex];

        if(hashItem == null){
            throw new IllegalArgumentException("No Records Found with the provided Key");
        }else{

            while (hashItem != null && !hashItem.getKey().equals(key)){
                hashItem = hashItem.getNextHashItem();
            }

            if(hashItem == null){
                throw new IllegalArgumentException("No Records Found with the provided Key");
            }

            return hashItem.getValue();
        }
    }

    public void put(K key, V value) {
        int hashArrayIndex = hash(key);
        System.out.println("generated hash key = " + hashArrayIndex);

        if (this.hashTable[hashArrayIndex] == null) {
            HashItem<K, V> hashItem = new HashItem<>(key, value);
            this.hashTable[hashArrayIndex] = hashItem;
        } else {
            HashItem<K, V> hashItem = this.hashTable[hashArrayIndex];
            while (hashItem.getNextHashItem() != null) {
                hashItem = hashItem.getNextHashItem();
            }

            hashItem.setNextHashItem(new HashItem<>(key, value));
        }
    }

    private int hash(K key) {
        return key.hashCode() % Constants.TABLE_SIZE;
    }


}
