package com.company;

public class newController {
    public static final int M_MAIN = 10;
    public static final int M_LIST = 1;
    public static final int M_ADD = 4;
    public static final int M_INFO = 9;

    Bookcase bookcase;
    boolean isLoop;
    int command;
    private int currentBookId;

    newController(Bookcase bookcase){
        this.bookcase = bookcase;
    }

    public void start(){
        isLoop = true;
        command = M_MAIN;

        while (isLoop){
            switch (command){
                case 0: //quit
                    isLoop = false;
                    break;
                case M_MAIN: //main menu
                    new newView(this).mainMenu();
                    break;
                case M_LIST: //print list books
                    new newView(this).listBooks(bookcase.getBooks());
                    break;
                case M_ADD: //add new book
                    new newView(this).addBook();
                    break;
            }
        }
    }
    public void addBook(Book book){
        bookcase.getBooks().add(book);
        bookcase.save();
    }

    public void closeView(){
        isLoop = false;
    }

    public void setCommand(int command){
        this.command = command;
    }

    public int getCurrentBookId() {
        return currentBookId;
    }

    public void setCurrentBookId(int currentBookId) {
        this.currentBookId = currentBookId;
    }
}
