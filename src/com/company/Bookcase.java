package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "books")
public class Bookcase {
    @XmlTransient
    public final static String FILE_NAME ="bookcase.xml";

    private static Bookcase instance;


    private List<Book> books;

    private Bookcase(){
    }
    /*
    @Deprecated
    Bookcase(List<Book> bookArr){
        this.books = bookArr;
    }*/

    @Deprecated
    public static Bookcase getInstance(){
        Bookcase bookcase = new Bookcase();

        try {
            JAXBContext jaxb = JAXBContext.newInstance(Bookcase.class);
            Unmarshaller unmarshaller = jaxb.createUnmarshaller();
            bookcase = (Bookcase) unmarshaller.unmarshal(new FileInputStream(FILE_NAME));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return bookcase;
    }

    public static synchronized Bookcase open(){
        if(instance==null){
            instance = new Bookcase();
            instance.setBooks(new ArrayList<>());

            File file = new File(FILE_NAME);
            try{
                JAXBContext jaxb = JAXBContext.newInstance(Bookcase.class);
                instance = (Bookcase) jaxb.createUnmarshaller().unmarshal(file);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }

        return instance;
    }
    public static synchronized boolean save(){
        if(instance!=null){
            File file = new File(FILE_NAME);
            try{
                JAXBContext jaxb = JAXBContext.newInstance(Bookcase.class);
                jaxb.createMarshaller().marshal(instance, file);
            } catch (JAXBException e) {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }

    public List<Book> getBooksByName(String name){
        List<Book> findBooks = new ArrayList<>();

        for(int i=0; i<books.size(); i++){
            if(name.equalsIgnoreCase(books.get(i).getName())){
                findBooks.add(books.get(i));
            }
        }

        return findBooks;
    }

    public List<Book> getBooksByAuthor(String author){
        List<Book> findBooks = new ArrayList<>();

        for(int i=0; i<books.size(); i++){
            if(author.equalsIgnoreCase(books.get(i).getAuthor().getName())){
                findBooks.add(books.get(i));
            }
        }

        return findBooks;
    }

    public boolean deleteThisBook(Book book){
        return books.remove(book);
    }


    public boolean isEmpty(){
        if(books!=null){
            return books.isEmpty();
        }
        return true;
    }

    @XmlElement(name = "book")
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> bookArr) {
        this.books = bookArr;
    }
}
