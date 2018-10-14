package com.company;


import java.util.Scanner;

public class ViewSearch {

    public static String inputName(){
        String name;

        System.out.println("Поиск книг");
        Scanner input = new Scanner(System.in);
        System.out.println("Введите название книги:");
        name = input.nextLine();

        return name;
    }

    public static String inputAuthor(){
        String name;

        System.out.println("Поиск книг");
        Scanner input = new Scanner(System.in);
        System.out.println("Введите имя автора:");
        name = input.nextLine();

        return name;
    }
}
