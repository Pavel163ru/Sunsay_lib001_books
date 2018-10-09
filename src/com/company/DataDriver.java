package com.company;

import java.util.ArrayList;

public class DataDriver {
    private Book book;
    private Author author;
    private ArrayList<Book> books = new ArrayList<>();


    public ArrayList<Book> getBooks(){

        //book = new Book("Book 1", 2000, new Author("Bob1"));
        for (int i=0; i<10; i++){
            book = new Book("Book "+i, (1900+i*13), new Author("Bob"+i));
            books.add(book);
        }
        return books;
    }

    public boolean setBooks(ArrayList<Book> books){
        this.books = books;
        return true;
    }
}
