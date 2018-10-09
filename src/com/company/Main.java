package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Book> books;
    private Book book;
    private Author author;
    private int year;

    private int menuMode;

    final static int MENU_BOOKS = 1;

    final static String MENU_MAIN_HINT = "Введите номер меню: ";

    private DataDriver dataDriver = new DataDriver();

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello Sunsay =)");

        Main m = new Main();

        m.loadBooks();
        m.printBooks();
        System.out.print("1.Вывест список книг \n" +
                "2.Поиск по автору \n"+
                "3.Поиск по названию \n"+
                "4.Добавить новую книгу \n");
        m.menuInput(MENU_MAIN_HINT);
        m.menu();

    }

    public void printBooks(){
        for(int i=0; i<books.size(); i++){
            book = books.get(i);
            System.out.println((i+1)+". '"+book.getName()+"' "+book.getAuthor().getName());
        }
    }
    public void loadBooks(){
        books = dataDriver.getBooks();
    }

    public void menu(){
        switch (menuMode){
            case 1:
                printBooks();
                break;
        }
    }

    public int menuInput(String hint){
        System.out.print(hint);
        Scanner in = new Scanner(System.in);
        menuMode = in.nextInt();
        System.out.println("menu mode = "+menuMode);

        return menuMode;
    }
}
