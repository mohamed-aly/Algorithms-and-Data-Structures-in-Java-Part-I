package com.ds.LRU;

public class App {
    public static void main(String[] args) {
        LRUCache<String> cache = new LRUCache<>();
        cache.put(1, "Mohamed");
        cache.put(2, "Mostafa");
        cache.put(3, "Ahmed");
        cache.put(4, "Abdo");

        System.out.println(cache.get(1));
        cache.show();
        System.out.println();

        System.out.println(cache.get(2));
        cache.show();
        System.out.println();

        System.out.println(cache.get(3));
        cache.show();
        System.out.println();


    }


}
