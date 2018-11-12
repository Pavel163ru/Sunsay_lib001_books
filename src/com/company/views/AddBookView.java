package com.company.views;

import com.company.Author;
import com.company.Book;
import com.company.Controller;

import java.util.Scanner;

public class AddBookView extends AbstractView implements Displayable {
    public AddBookView(Controller controller) {
        super(controller);
    }

    @Override
    public void display() {
        System.out.println("Добавление новой книги");
        Book book = new Book();
        Scanner input = new Scanner(System.in);
        System.out.println("Введите название книги:");
        book.setName(input.nextLine());
        System.out.println("Введите имя автора:");
        book.setAuthor(new Author(input.nextLine()));
        System.out.println("Введите год выпуска:");
        book.setYear(input.nextInt());

        controller.addBook(book);
        System.out.println("Книга успешно добавлена, прощай человек");
        controller.orderViewMainMenu();
    }
}
