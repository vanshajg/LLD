package com.vanshajgirotra.designpatterns.decorator.toppings;

import com.vanshajgirotra.designpatterns.decorator.pizza.Pizza;

public class ExtraCheese extends Topping {

    public ExtraCheese(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        System.out.println("adding cost of extra cheese");
        return this.pizza.cost() + 20;
    }
}
