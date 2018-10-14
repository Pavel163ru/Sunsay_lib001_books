package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.List;


public class Main {
    private List<Book> books;
    private Book book;
    private Author author;
    private int year;
    private Bookcase bookcase;


    final static int MENU_BOOKS = 1;
    final static int MENU_MAIN = 0;

    final static String MENU_MAIN_HINT = "Введите номер меню: ";



    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello Sunsay =)");

        new Controller().start(Bookcase.open());



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


