package com.ds.binarySearchTree.familyAgeProblem;

public class Main {
    public static void main(String[] args) {
        Family family = new Family();
        family.addMember(new Person("ahmed", 10));
        family.addMember(new Person("aly", 20));
        family.addMember(new Person("mohamed", 25));
        family.addMember(new Person("rody", 5));
        family.addMember(new Person("abdo", 11));
        family.addMember(new Person("mostafa", 6));
        family.addMember(new Person("ad", 3));

        System.out.println(family.agesSum());
    }
}
