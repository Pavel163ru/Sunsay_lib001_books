package com.company;

import java.util.Scanner;

public class ViewEditBook {
    public static void editBook(Book book){
        System.out.println("Редактирование книги");

        Scanner input = new Scanner(System.in);
        System.out.println("Введите название книги:");
        book.setName(input.nextLine());
        System.out.println("Введите имя автора:");
        book.setAuthor(new Author(input.nextLine()));
        System.out.println("Введите год выпуска:");
        book.setYear(input.nextInt());

        System.out.println("...Книга успешно изменена");
    }
}
