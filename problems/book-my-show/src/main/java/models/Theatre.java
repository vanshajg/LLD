package models;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Theatre {

    private String id;
    private String name;
    private Location location;
    private List<Screen> screens;
    private List<Show> shows;

}
