package com.company;

import java.util.Scanner;

public class ViewBook {
    ViewBook(){}

    public static int bookInfo(Book book){

        System.out.println("Название книги: "+ book.getName());
        System.out.println("Автор: "+ book.getAuthor().getName());
        System.out.println("Год: "+ book.getYear());

        System.out.println("Введите: 0-главное меню; 1-редактировать; 2-удалить");
        Scanner input = new Scanner(System.in);
        int command;
        boolean isCorrect;
        do {
            command = input.nextInt();
            isCorrect = command>=0 && command<=2;
            System.out.println(isCorrect ? "":"Ошибка ввода, повторите попытку");
        }while (!isCorrect);
        return command;
    }
}
