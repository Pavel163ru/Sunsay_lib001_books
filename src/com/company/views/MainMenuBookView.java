package com.company.views;

import com.company.Controller;

import java.util.Scanner;

public class MainMenuBookView extends AbstractBookView implements Displayable{
    public MainMenuBookView(Controller controller) {
        super(controller);
    }

    @Override
    public void display() {
        System.out.print("---Главное меню--- \n"+
                "1.Вывест список книг \n" +
                "2.Поиск по названию книги \n" +
                "3.Поиск по имени автора \n" +
                "4.Добавить новую книгу \n"+
                "0.Выход \n");

        System.out.print("Введите команду: ");
        Scanner in = new Scanner(System.in);
        int command = in.nextInt();
        switch(command){
            case Controller.M_LIST:
                controller.showBooksList();
                break;
            case Controller.M_SEARCH_BOOK:
                controller.showSearchBookName();
                break;
            case Controller.M_SEARCH_AUTHOR:
                controller.showSearchBookAuthor();
                break;
            case Controller.M_ADD:
                controller.showBookAdd();
                break;
            default:
                controller.showExit();
        }
    }
}
