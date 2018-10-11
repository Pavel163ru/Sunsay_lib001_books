package com.company;

public class ViewBook {
    ViewBook(){}

    public static void bookInfo(Bookcase bookcase, int index){
        Book book = bookcase.getBooks().get(index);
        System.out.println("Название книги: "+ book.getName());
        System.out.println("Автор: "+ book.getAuthor().getName());
        System.out.println("Год: "+ book.getYear());
    }
}
