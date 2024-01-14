package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location {

    private String name;
    private String address;
    private String city;
    private String state;
    private String pinCode;
    private String country;

}
