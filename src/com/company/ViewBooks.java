package com.company;


import java.util.List;
import java.util.Scanner;

public class ViewBooks {
    ViewBooks(){

    }

    @Deprecated
    public static int bookList(Bookcase bookcase){
        if(bookcase.isEmpty()){
            System.out.println("Список пуст, добавте новую книгу");
        }else {


            List<Book> books = bookcase.getBooks();
            Book book;

            for (int i = 0; i < books.size(); i++) {
                book = books.get(i);
                System.out.println((i + 1) + ". '" + book.getName() + "' " + book.getAuthor().getName());
            }
        }

        int menu;
        System.out.println("Введите: 0-главное меню; №-информация о книге");
        Scanner input = new Scanner(System.in);
        do {
            menu = input.nextInt();
            System.out.println((menu<=bookcase.getBooks().size() ? "":"Ошибка ввода, подумайте и повторите попытку"));
        }while (menu>bookcase.getBooks().size());

    return menu;
    }

    public static int bookList(List<Book> books){
        if(books.isEmpty()){
            System.out.println("Список пуст, добавте новую книгу");
        }else {

            Book book;

            System.out.println("А вот и списочек книг");

            for (int i = 0; i < books.size(); i++) {
                book = books.get(i);
                System.out.println((i + 1) + ". '" + book.getName() + "' " + book.getAuthor().getName());
            }
        }

        int menu;
        System.out.println("Введите: 0-главное меню; №-информация о книге");
        Scanner input = new Scanner(System.in);
        do {
            menu = input.nextInt();
            System.out.println((menu<=books.size() ? "":"Ошибка ввода, повторите попытку"));
        }while (menu>books.size());

        return menu;
    }

}
