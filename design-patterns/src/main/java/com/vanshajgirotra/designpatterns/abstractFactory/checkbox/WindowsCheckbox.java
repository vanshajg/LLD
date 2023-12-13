package com.vanshajgirotra.designpatterns.abstractFactory.checkbox;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void check() {
        System.out.println("You have checked a Windows checkbox.");
    }
}
