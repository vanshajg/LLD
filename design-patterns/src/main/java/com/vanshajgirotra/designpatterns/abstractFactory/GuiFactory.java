package com.vanshajgirotra.designpatterns.abstractFactory;

import com.vanshajgirotra.designpatterns.abstractFactory.button.Button;
import com.vanshajgirotra.designpatterns.abstractFactory.checkbox.Checkbox;

public interface GuiFactory {
    Button createButton();

    Checkbox createCheckbox();
}
