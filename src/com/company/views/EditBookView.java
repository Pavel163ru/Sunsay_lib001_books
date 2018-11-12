package com.company.views;

import com.company.Author;
import com.company.Book;
import com.company.Controller;

import java.util.Scanner;

public class EditBookView extends AbstractView implements Displayable {
    Book book;
    public EditBookView(Controller controller, Book book) {
        super(controller);
        this.book = book;
    }

    @Override
    public void display() {
        System.out.println("Редактирование книги");

        Scanner input = new Scanner(System.in);
        System.out.println("Введите название книги:");
        book.setName(input.nextLine());
        System.out.println("Введите имя автора:");
        book.setAuthor(new Author(input.nextLine()));
        System.out.println("Введите год выпуска:");
        book.setYear(input.nextInt());

        controller.save();
        System.out.println("...Книга успешно изменена");
        controller.orderViewBook(book);
    }
}
