package com.company.views;

import com.company.Controller;

import java.util.Scanner;

public class MainMenuView extends AbstractView implements Displayable{
    public MainMenuView(Controller controller) {
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
        controller.setCommand(command);
    }
}
