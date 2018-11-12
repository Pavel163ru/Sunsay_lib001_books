package com.company.views;

import com.company.Book;
import com.company.Controller;

import java.util.List;
import java.util.Scanner;

public class ListBooksView extends AbstractView implements Displayable {
    List<Book> books;

    public ListBooksView(Controller controller, List<Book> books) {
        super(controller);
        this.books = books;
    }

    @Override
    public void display() {
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
            System.out.println((menu <= books.size() ? "":"Ошибка ввода, повторите попытку"));
        }while (menu > books.size());

        if(menu > 0){
            controller.orderViewBook(books.get(menu-1));
        }else{
            controller.orderViewMainMenu();
        }
    }
}
