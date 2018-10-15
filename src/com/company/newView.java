package com.company;

import java.util.List;
import java.util.Scanner;

public class newView {
    newController controller;

    newView(newController controller){
        this.controller = controller;
    }

    public void mainMenu(){
        System.out.print("---Главное меню--- \n"+
                "1.Вывест список книг \n" +
                "2.Поиск по названию книги \n" +
                "3.Поиск по имени автора \n" +
                "4.Добавить новую книгу \n"+
                "0.Выход \n");

        System.out.print("Введите команду: ");
        Scanner in = new Scanner(System.in);
        int command = in.nextInt();
        controller.setCommand(command);
    }

    public void listBooks(List<Book> books){
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

        if(menu>0){
            controller.setCurrentBookId(menu-1);
            controller.setCommand(newController.M_LIST);
        }else{
            controller.setCommand(newController.M_MAIN);
        }
    }
    public void addBook(){
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
        controller.setCommand(newController.M_MAIN);
    }
}
