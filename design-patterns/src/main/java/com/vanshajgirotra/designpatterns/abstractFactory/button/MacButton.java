package com.vanshajgirotra.designpatterns.abstractFactory.button;

public class MacButton implements Button {
    @Override
    public void click() {
        System.out.println("Mac button clicked");
    }
}
