package com.company.views;

import com.company.Book;
import com.company.Controller;

import java.util.Scanner;

public class BookInfoView extends AbstractView implements Displayable {
    Book book;

    public BookInfoView(Controller controller, Book book) {
        super(controller);
        this.book = book;
    }

    @Override
    public void display() {
        System.out.println("Название книги: "+ book.getName());
        System.out.println("Автор: "+ book.getAuthor().getName());
        System.out.println("Год: "+ book.getYear());

        System.out.println("Введите: 0-главное меню; 1-редактировать; 2-удалить");
        Scanner input = new Scanner(System.in);
        int command;
        boolean isCorrect;
        do {
            command = input.nextInt();
            isCorrect = command >= 0 && command <= 2;
            System.out.println(isCorrect ? "":"Ошибка ввода, повторите попытку");
        }while (!isCorrect);

        switch (command){
            case 0:
                controller.orderViewMainMenu();
                break;
            case 1:
                controller.orderViewBookEdit(book);
                break;
            case 2:
                controller.delBook(book);
                System.out.println("...Книга удалена");
                controller.orderViewMainMenu();
                break;
        }
    }
}
