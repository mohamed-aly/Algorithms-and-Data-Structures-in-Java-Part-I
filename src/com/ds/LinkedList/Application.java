package com.ds.LinkedList;

public class Application {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("mohamed");
        System.out.println(list.size());
        list.add("ahmed");
        list.add("mostafa");
        list.add("abdo");
        System.out.println(list.size());
        list.traverse();
        list.remove("ahmed");
        System.out.println(list.size());
        list.traverse();
    }
}
