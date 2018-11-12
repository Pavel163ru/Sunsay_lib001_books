package com.company.views;

import com.company.Controller;

public class ExitView extends AbstractView implements Displayable {
    public ExitView(Controller controller) {
        super(controller);
    }

    @Override
    public void display() {
        System.out.println("...Завершение работы, не выключайте компьютер");
    }
}
