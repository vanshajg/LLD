package com.vanshajgirotra.designpatterns.decorator.pizza;

public class Farmhouse extends Pizza {
    @Override
    public int cost() {
        System.out.println("adding cost of farmhouse");
        return 20;
    }
}
