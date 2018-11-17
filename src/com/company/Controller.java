package com.company;

import com.company.views.*;

import java.util.List;

public class Controller {
    public static final int M_MAIN = 10;
    public static final int M_LIST = 1;
    public static final int M_SEARCH_BOOK = 2;
    public static final int M_SEARCH_AUTHOR = 3;
    public static final int M_ADD = 4;
    public static final int M_CURRENT = 5;
    public static final int M_EDIT = 8;
    public static final int M_INFO = 9;
    public static final int M_EXIT = 0;

    Bookcase bookcase;

    private int currentBookId;
    private List<Book> currentBooks;
    private Book currentBook;


    Controller(Bookcase bookcase){
        this.bookcase = bookcase;
    }

    public void showExit(){
        new ExitBookView(this).display();
    }
    public void showSearchBookName(){
        new SearchBookNameBookView(this).display();
    }
    public void showSearchBookAuthor(){
        new SearchBookAuthorBookView(this).display();
    }
    public void showCurrentList(){
        new ListBooksBookView(this, currentBooks).display();
    }
    public void showBookAdd(){
        new AddBookBookView(this).display();
    }
    public void showBooksList(){
        new ListBooksBookView(this, bookcase.getBooks()).display();
    }
    public void showMainMenu(){
        new MainMenuBookView(this).display();
    }
    public void showBookInfo(Book book){
        currentBook = book;
        new BookInfoBookView(this, currentBook).display();
    }
    public void showBookEdit(Book book){
        currentBook = book;
        new EditBookBookView(this, currentBook).display();
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

    public int getCurrentBookId() {
        return currentBookId;
    }

    public void setCurrentBookId(int currentBookId) {
        this.currentBookId = currentBookId;
    }
}
