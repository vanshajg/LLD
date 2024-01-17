package models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Movie {

    private String id;
    private String name;
    private String language;

}
