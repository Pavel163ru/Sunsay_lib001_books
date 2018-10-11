package com.company;

import java.util.ArrayList;
import java.util.List;

public class DataDriver {
    private Book book;
    private Author author;
    private List<Book> books = new ArrayList<>();


    public List<Book> getBooks(){

        //book = new Book("Book 1", 2000, new Author("Bob1"));
        for (int i=0; i<10; i++){
            book = new Book("Book "+i, (1900+i*13), new Author("Bob"+i));
            books.add(book);
        }
        return books;
    }

    public boolean setBooks(List<Book> books){
        this.books = books;
        return true;
    }
}
