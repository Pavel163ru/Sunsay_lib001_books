package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<Book> books;
    private Book book;
    private Author author;
    private int year;
    private Bookcase bookcase;

    private int menuMode;

    final static int MENU_BOOKS = 1;
    final static int MENU_MAIN = 0;

    final static String MENU_MAIN_HINT = "Введите номер меню: ";

    private DataDriver dataDriver = new DataDriver();

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello Sunsay =)");
        Main m = new Main();
        m.mainLogic();



    }
    public void mainLogic(){

        /*
        bookcase = Bookcase.getInstance();
        //если ещё нет файла создаем макет
        if(bookcase.isEmpty()){
            loadBooks();
            testXMLsave();
        }*/


        /*

        System.out.print("1.Вывест список книг \n" +
                "2.Поиск по автору \n" +
                "3.Поиск по названию \n" +
                "4.Добавить новую книгу \n");
        menuInput(MENU_MAIN_HINT);
        menu();

        newBook();
        */

        //testXMLload();




        bookcase = Bookcase.open();
        //bookcase.setBooks(new DataDriver().getBooks());
        //bookcase.save();
        ViewAddBook.addBook(bookcase);

        menuMode = ViewBooks.bookList(bookcase);
        if(menuMode>0){
            int index = menuMode - 1;
            ViewBook.bookInfo(bookcase, index);
        }
        Bookcase.save();
        //printBooks();

    }

    public void printBooks() {
        if(bookcase.isEmpty()){
            System.out.println("Список пуст, добавте новую книгу");
            return;
        }
        books = bookcase.getBooks();
        for (int i = 0; i < books.size(); i++) {
            book = books.get(i);
            System.out.println((i + 1) + ". '" + book.getName() + "' " + book.getAuthor().getName());
        }
    }

    @Deprecated
    public void loadBooks() {
        books = dataDriver.getBooks();
        //bookcase = new Bookcase(books);
    }

    public void menu() {
        switch (menuMode) {
            case 1:
                printBooks();
                break;
        }
    }

    public int menuInput(String hint) {
        System.out.print(hint);
        Scanner in = new Scanner(System.in);
        menuMode = in.nextInt();
        System.out.println("menu mode = " + menuMode);

        return menuMode;
    }

    public void newBook() {
        Scanner in = new Scanner(System.in);
        String[] strings = new String[5];
        System.out.println("Введите название книги " + strings.length);
        for (int i = 0; i < strings.length; i++) {
            strings[i] = in.nextLine();
        }
        System.out.println("You enter this lines :");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }


    }

    //temp for test
    void testXML(){

        //Bookcase bookcase = new Bookcase(books);



        StringWriter writer = new StringWriter();

        JAXBContext context = null;
        //ide порекомендовала все это в трай засунуть
        try {
            context = JAXBContext.newInstance(Book.class, Author.class, Bookcase.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bookcase, writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        String result = writer.toString();
        System.out.println(result);

        //un marshall
        StringReader reader = new StringReader(result);
        try {
            JAXBContext jaxb = JAXBContext.newInstance(Bookcase.class, Book.class, Author.class);
            Unmarshaller unmarshaller = jaxb.createUnmarshaller();
            bookcase = (Bookcase) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
    void testXMLsave(){
        //Bookcase bookcase = new Bookcase(books);


        //StringWriter writer = new StringWriter();

        //JAXBContext context = null;
        //ide порекомендовала все это в трай засунуть
        try {
            JAXBContext context = JAXBContext.newInstance(Bookcase.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bookcase, new FileOutputStream("bookcase.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //String result = writer.toString();
        //System.out.println(result);

        //un marshall
        //StringReader reader = new StringReader(result);

    }
    void testXMLload(){
        try {
            JAXBContext jaxb = JAXBContext.newInstance(Bookcase.class);
            Unmarshaller unmarshaller = jaxb.createUnmarshaller();
            bookcase = (Bookcase) unmarshaller.unmarshal(new FileInputStream("bookcase.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


