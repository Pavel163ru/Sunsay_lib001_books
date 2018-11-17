package com.company.views;

import com.company.Controller;

public class ExitBookView extends AbstractBookView implements Displayable {
    public ExitBookView(Controller controller) {
        super(controller);
    }

    @Override
    public void display() {
        System.out.println("...Завершение работы, не выключайте компьютер");
    }
}
