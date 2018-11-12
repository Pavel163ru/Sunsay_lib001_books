package com.company.views;

import com.company.Controller;

abstract class AbstractView {
    Controller controller;

    public AbstractView(Controller controller){
        this.controller = controller;
    }
}
