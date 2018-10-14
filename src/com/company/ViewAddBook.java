package com.company;

import java.util.Scanner;

public class ViewAddBook {

    public static void addBook(Bookcase bookcase){
        System.out.println("Добавление новой книги");
        Book book = new Book();
        Scanner input = new Scanner(System.in);
        System.out.println("Введите название книги:");
        book.setName(input.nextLine());
        System.out.println("Введите имя автора:");
        book.setAuthor(new Author(input.nextLine()));
        System.out.println("Введите год выпуска:");
        book.setYear(input.nextInt());

        bookcase.getBooks().add(book);
        System.out.println("Книга успешно добавлена, прощай человек");
    }
    public static Book addBook(){
        System.out.println("Добавление новой книги");
        Book book = new Book();
        Scanner input = new Scanner(System.in);
        System.out.println("Введите название книги:");
        book.setName(input.nextLine());
        System.out.println("Введите имя автора:");
        book.setAuthor(new Author(input.nextLine()));
        System.out.println("Введите год выпуска:");
        book.setYear(input.nextInt());

        System.out.println("Книга успешно добавлена, прощай человек");
        return book;
    }
}
