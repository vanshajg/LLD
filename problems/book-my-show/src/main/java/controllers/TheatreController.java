package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import models.City;
import models.Movie;
import models.Theatre;

public class TheatreController {
    private final Map<City, List<Theatre>> theatresByCity = new HashMap<>();

    @Getter
    private final List<Theatre> theatres = new ArrayList<>();

    public void addTheatre(Theatre theatre, City city) {
        theatres.add(theatre);
        theatresByCity.putIfAbsent(city, new ArrayList<>());
        theatresByCity.get(city).add(theatre);
    }

    public void removeTheatre(City city, Theatre theatre) {
        theatres.remove(theatre);
        theatresByCity.get(city).remove(theatre);
    }

    public List<Theatre> getTheatresByCity(City city) {
        return theatresByCity.get(city);
    }

    public List<Theatre> getTheatresByMovie(City city, Movie movie) {
        return theatresByCity.getOrDefault(city, Collections.emptyList())
                .stream()
                .filter(theatre -> theatre.getShows().stream().anyMatch(show -> show.getMovie().equals(movie)))
                .toList();
    }
}

