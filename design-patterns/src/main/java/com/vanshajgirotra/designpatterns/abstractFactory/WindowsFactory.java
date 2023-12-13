package com.vanshajgirotra.designpatterns.abstractFactory;

import com.vanshajgirotra.designpatterns.abstractFactory.button.Button;
import com.vanshajgirotra.designpatterns.abstractFactory.button.WindowsButton;
import com.vanshajgirotra.designpatterns.abstractFactory.checkbox.Checkbox;
import com.vanshajgirotra.designpatterns.abstractFactory.checkbox.WindowsCheckbox;

public class WindowsFactory implements GuiFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
