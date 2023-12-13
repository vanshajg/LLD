package com.vanshajgirotra.designpatterns.decorator.toppings;

import com.vanshajgirotra.designpatterns.decorator.pizza.Pizza;

public class Oregano extends Topping {

    public Oregano(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        System.out.println("adding cost of oregano");
        return this.pizza.cost() + 10;
    }
}
