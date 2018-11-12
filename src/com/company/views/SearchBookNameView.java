package com.company.views;

import com.company.Controller;

import java.util.Scanner;

public class SearchBookNameView extends AbstractView implements Displayable {
    public SearchBookNameView(Controller controller) {
        super(controller);
    }

    @Override
    public void display() {
        String name;

        System.out.println("-Поиск книг-");
        Scanner input = new Scanner(System.in);
        System.out.println("Введите название книги:");
        name = input.nextLine();

        controller.setCurrentBooksByName(name);
        controller.orderViewCurrentList();
    }
}
