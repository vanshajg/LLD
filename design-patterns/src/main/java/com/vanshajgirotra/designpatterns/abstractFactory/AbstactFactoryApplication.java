package com.vanshajgirotra.designpatterns.abstractFactory;

import com.vanshajgirotra.designpatterns.abstractFactory.button.Button;
import com.vanshajgirotra.designpatterns.abstractFactory.checkbox.Checkbox;

public class AbstactFactoryApplication {
    public static void main(String[] args) {
        GuiFactory factory = new WindowsFactory();
        Button button = factory.createButton();
        button.click();
        Checkbox checkbox = factory.createCheckbox();
        checkbox.check();
    }
}
