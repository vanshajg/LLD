package com.vanshajgirotra.designpatterns.decorator;

import com.vanshajgirotra.designpatterns.decorator.pizza.Pizza;
import com.vanshajgirotra.designpatterns.decorator.pizza.Farmhouse;
import com.vanshajgirotra.designpatterns.decorator.toppings.ExtraCheese;
import com.vanshajgirotra.designpatterns.decorator.toppings.Oregano;

public class DecoratorApplication {
    public static void main(String[] args) {
        Pizza pizza = new Oregano(new ExtraCheese(new Oregano(new Farmhouse())));
        System.out.println(pizza.cost());
    }
}
