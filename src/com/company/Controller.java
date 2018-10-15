package com.company;

import java.util.List;
import java.util.Scanner;

public class Controller {
    Bookcase bookcase;
    Book book;
    int currentMenuId;
    int currentBookId;
    int command;
    List<Book> currentBooks;


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
                    if(currentMenuId==1) currentBooks = bookcase.getBooks();
                    break;
                case 1: //Список книг
                    command = ViewBooks.bookList(currentBooks);
                    if(command>0){
                        currentBookId = command - 1;
                        currentMenuId = 5;
                    }else currentMenuId = 0;
                    break;
                case 2:// поиск названию
                    String name = ViewSearch.inputName();
                    currentBooks = bookcase.getBooksByName(name);
                    currentMenuId = 1;
                    break;
                case 3://поиск по автору
                    String author = ViewSearch.inputAuthor();
                    currentBooks = bookcase.getBooksByAuthor(author);
                    currentMenuId = 1;
                    break;
                case 4: //Добавление книги
                    ViewAddBook.addBook(bookcase);
                    bookcase.save();
                    currentMenuId = 0;
                    break;
                case 5: //Информация о книге
                    book = currentBooks.get(currentBookId);
                    command = ViewBook.bookInfo(book);
                    if(command == 0){
                        currentMenuId = 0;//главное меню
                    }else if (command == 1){
                        currentMenuId = 6;//редактирование
                    }else if (command == 2){
                        currentMenuId = 7;//удаление
                    }
                    break;
                case 6://todo редактирование
                    book = currentBooks.get(currentBookId);
                    ViewEditBook.editBook(book);
                    bookcase.save();
                    currentMenuId = 0;
                    break;
                case 7://todo удаление
                    book = currentBooks.get(currentBookId);
                    boolean result = bookcase.deleteThisBook(book);
                    if (result){
                        System.out.println("...Книга удалена успешно");
                        bookcase.save();
                    }else{
                        System.out.println("...Ошибка удаления");
                    }

                    currentMenuId = 0;
                    break;
            }
        }
        System.out.println("...Завершение работы, не выключайте компьютер");

        Bookcase.save();
    }

}
