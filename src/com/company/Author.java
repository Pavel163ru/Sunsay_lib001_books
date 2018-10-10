package com.company;

import javax.xml.bind.annotation.XmlType;

//@XmlType(name = "a")
public class Author {
    private String name;
    private String sex;

    Author(){
    }

    Author(String name){
        this.name = name;
    }

    //refactor
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
