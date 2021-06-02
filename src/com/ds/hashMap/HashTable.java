package com.ds.hashMap;

public class HashTable<K, V> {
    private HashItem<K, V>[] hashTable;

    public void put(K key, V value) {
        int hashArrayIndex = hash(key);

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
