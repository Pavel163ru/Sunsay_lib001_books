package com.company;


public class Main {
    private Bookcase bookcase;


    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello Sunsay =)");

        new Controller(Bookcase.open()).start();
    }
}


