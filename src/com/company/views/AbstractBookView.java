package com.company.views;

import com.company.Book;
import com.company.Controller;

import java.util.List;

abstract class AbstractBookView {
    Book book;
    List<Book> books;
    Controller controller;

    public AbstractBookView(Controller controller){
        this.controller = controller;
    }
}
