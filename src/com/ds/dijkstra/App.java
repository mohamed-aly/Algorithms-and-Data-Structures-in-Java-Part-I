package com.ds.dijkstra;

public class App {
    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        algorithm.interpret("( ( 20 + 352 ) * ( 2 + 3 ) )");
        System.out.println(algorithm.result());
    }
}
