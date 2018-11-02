package com.company;

import java.util.List;
import java.util.Scanner;

public class View {
    Controller controller;

    View(Controller controller){
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
            System.out.println((menu <= books.size() ? "":"Ошибка ввода, повторите попытку"));
        }while (menu > books.size());

        if(menu > 0){
            controller.orderViewBook(books.get(menu-1));
        }else{
            controller.orderViewMainMenu();
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
        controller.orderViewMainMenu();
    }

    public void searchBookName(){
        String name;

        System.out.println("-Поиск книг-");
        Scanner input = new Scanner(System.in);
        System.out.println("Введите название книги:");
        name = input.nextLine();

        controller.setCurrentBooksByName(name);
        controller.orderViewCurrentList();
    }
    public void searchBookAuthor(){
        String name;

        System.out.println("-Поиск книг-");
        Scanner input = new Scanner(System.in);
        System.out.println("Введите имя автора:");
        name = input.nextLine();

        controller.setCurrentBooksByAuthor(name);
        controller.orderViewCurrentList();
    }
    public void exit(){
        System.out.println("...Завершение работы, не выключайте компьютер");
    }
    public void info(Book book){
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
    public void editBook(Book book){
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
