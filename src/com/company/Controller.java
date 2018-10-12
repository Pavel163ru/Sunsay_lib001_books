package com.company;

import java.util.Scanner;

public class Controller {
    Bookcase bookcase;
    Book book;
    int currentMenuId;
    int currentBookId;
    int command;


    Controller(){}

    public void start(Bookcase bookcase){
        this.bookcase = bookcase;

        currentMenuId = 0;
        currentBookId = 0;




        while (currentMenuId!=-1){
            switch (currentMenuId){
                case 0: //Главное меню
                    command = ViewMainMenu.menu();
                    currentMenuId = command==0 ? -1 : command;
                    break;
                case 1: //Список книг
                    command = ViewBooks.bookList(bookcase);
                    if(command>0){
                        currentBookId = command - 1;
                        currentMenuId = 5;
                    }else currentMenuId = 0;
                    break;
                case 2:
                    currentMenuId = 0;
                    break;
                case 3:
                    currentMenuId = 0;
                    break;
                case 4: //Добавление книги
                    ViewAddBook.addBook(bookcase);
                    break;
                case 5: //Информация о книге
                    book = bookcase.getBooks().get(currentBookId);
                    command = ViewBook.bookInfo(book);
                    if(command == 0){
                        currentMenuId = 0;//главное меню
                    }else if (command == 1){
                        currentMenuId = 6;//редактирование
                    }else if (command == 2){
                        currentMenuId = 7;//удаление
                    }
                    break;
                case 6://редактирование
                    currentMenuId = -1;
                    break;
                case 7://удаление
                    currentMenuId = -1;
                    break;
            }
        }
        System.out.println("Завершение работы, не выключайте компьютер");

        Bookcase.save();
    }
}
