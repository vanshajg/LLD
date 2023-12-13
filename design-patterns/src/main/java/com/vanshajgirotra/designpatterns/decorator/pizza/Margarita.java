package com.vanshajgirotra.designpatterns.decorator.pizza;

public class Margarita extends Pizza {
    @Override
    public int cost() {
        System.out.println("adding cost of margarita");
        return 10;
    }
}
