package models.product;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Vehicle {

    private String id;
    private String name;
    private String color;
    private String number;
    private Type type;
    private Status status;

    public enum Type {
        CAR,
        BIKE
    }

    public enum Status {
        ACTIVE,
        INACTIVE
    }

}
