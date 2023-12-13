package com.vanshajgirotra.designpatterns.abstractFactory;

import com.vanshajgirotra.designpatterns.abstractFactory.button.Button;
import com.vanshajgirotra.designpatterns.abstractFactory.button.MacButton;
import com.vanshajgirotra.designpatterns.abstractFactory.checkbox.Checkbox;
import com.vanshajgirotra.designpatterns.abstractFactory.checkbox.MacCheckbox;

public class MacFactory implements GuiFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
