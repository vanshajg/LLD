package com.vanshajgirotra.multithreading.shoeWarehouse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
@AllArgsConstructor
public class Order {

    private int orderId;
    private String shoeType;
    private int quantity;

}
