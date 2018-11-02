package com.company;

import java.util.List;

public class Controller {
    public static final int M_MAIN = 10;
    public static final int M_LIST = 1;
    public static final int M_SEBOOK = 2;
    public static final int M_SEARCH_AUTHOR = 3;
    public static final int M_ADD = 4;
    public static final int M_CURRENT = 5;
    public static final int M_EDIT = 8;
    public static final int M_INFO = 9;
    public static final int M_EXIT = 0;

    Bookcase bookcase;
    boolean isLoop;
    int command;
    private int currentBookId;
    private List<Book> currentBooks;
    private Book currentBook;
    private String bookName;
    private String authorName;

    Controller(Bookcase bookcase){
        this.bookcase = bookcase;
    }

    public void start(){
        isLoop = true;
        command = M_MAIN;

        while (isLoop){
            switch (command){
                case M_EXIT: //quit
                    showExit();
                    exit();
                    break;
                case M_MAIN: //main menu
                    showMainMenu();
                    break;
                case M_LIST: //print list books
                    showBooksList();
                    break;
                case M_SEBOOK:
                    showSearchBookName();
                    break;
                case M_SEARCH_AUTHOR:
                    showSearchBookAuthor();
                    break;
                case M_CURRENT:
                    showCurrentList();
                    break;
                case M_ADD: //add new book
                    showBookAdd();
                    break;
                case M_INFO:
                    showBookInfo();
                    break;
                case M_EDIT:
                    showBookEdit();
                    break;

            }
        }
    }

    private void showExit(){
        new View(this).exit();
    }
    private void showSearchBookName(){
        new View(this).searchBookName();
    }
    private void showSearchBookAuthor(){
        new View(this).searchBookAuthor();
    }
    private void showCurrentList(){
        new View(this).listBooks(currentBooks);
    }
    private void showBookAdd(){
        new View(this).addBook();
    }
    private void showBooksList(){
        new View(this).listBooks(bookcase.getBooks());
    }
    private void showMainMenu(){
        new View(this).mainMenu();
    }
    private void showBookInfo(){
        new View(this).info(currentBook);
    }
    private void showBookEdit(){
        new View(this).editBook(currentBook);
    }


    public void orderViewSearchBooks(){
        command = M_SEBOOK;
    }
    public void orderViewMainMenu(){
        command = M_MAIN;
    }
    public void orderViewBooksList (){
        command = M_LIST;
    }
    public void orderViewCurrentList (){
        command = M_CURRENT;
    }
    public void orderViewBook(Book book){
        currentBook = book;
        command = M_INFO;
    }
    public void orderViewBookEdit(Book book){
        command = M_EDIT;
    }


    public void setCurrentBooksByName(String name){
        currentBooks = bookcase.getBooksByName(name);
    }

    public void setCurrentBooksByAuthor(String name){
        currentBooks = bookcase.getBooksByAuthor(name);
    }

    public void addBook(Book book){
        bookcase.getBooks().add(book);
        bookcase.save();
    }
    public void delBook(Book book){
        bookcase.deleteThisBook(book);
        bookcase.save();
    }

    public void save(){
        bookcase.save();
    }

    public void exit(){
        isLoop = false;
    }

    public void setCommand(int command){
        this.command = command;
    }

    public int getCurrentBookId() {
        return currentBookId;
    }

    public void setCurrentBookId(int currentBookId) {
        this.currentBookId = currentBookId;
    }
}
