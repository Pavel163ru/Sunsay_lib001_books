package com.company.views;

import com.company.Controller;

import java.util.Scanner;

public class SearchBookAuthorBookView extends AbstractBookView implements Displayable {
    public SearchBookAuthorBookView(Controller controller) {
        super(controller);
    }

    @Override
    public void display() {
        String name;

        System.out.println("-Поиск книг-");
        Scanner input = new Scanner(System.in);
        System.out.println("Введите имя автора:");
        name = input.nextLine();

        controller.setCurrentBooksByAuthor(name);
        controller.showCurrentList();
    }
}
