package models;

import java.util.List;

import lombok.Builder;

@Builder
public class Screen {

    private String id;
    private String name;
    private List<Seat> seats;
    private Show show;

}
