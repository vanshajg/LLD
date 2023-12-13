package com.vanshajgirotra.designpatterns.factory;

import com.vanshajgirotra.designpatterns.factory.transport.Plane;
import com.vanshajgirotra.designpatterns.factory.transport.Ship;
import com.vanshajgirotra.designpatterns.factory.transport.Transport;
import com.vanshajgirotra.designpatterns.factory.transport.Truck;

public class TransportFactory {
    public static Transport buildTransport(String transportType) {
        return switch (transportType) {
            case "truck" -> new Truck();
            case "ship" -> new Ship();
            case "plane" -> new Plane();
            default -> throw new IllegalArgumentException("Invalid transport type");
        };
    }
}
