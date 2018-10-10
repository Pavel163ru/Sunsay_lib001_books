package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;


@XmlRootElement
public class Bookcase {


    private ArrayList<Book> books = new ArrayList<>();

    Bookcase(){
    }
    Bookcase(ArrayList<Book> bookArr){
        this.books = bookArr;
    }

    public static Bookcase getInstance(){
        Bookcase bookcase = new Bookcase();

        try {
            JAXBContext jaxb = JAXBContext.newInstance(Bookcase.class);
            Unmarshaller unmarshaller = jaxb.createUnmarshaller();
            bookcase = (Bookcase) unmarshaller.unmarshal(new FileInputStream("bookcase.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return bookcase;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> bookArr) {
        this.books = bookArr;
    }
}
