package com.vanshajgirotra.designpatterns.abstractFactory.checkbox;

public class MacCheckbox implements Checkbox {
    @Override
    public void check() {
        System.out.println("You have checked a Mac checkbox.");
    }
}
