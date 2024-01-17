package models;

import lombok.Builder;

@Builder
public class Location {

    private String id;
    private City city;
    private String address;

}
