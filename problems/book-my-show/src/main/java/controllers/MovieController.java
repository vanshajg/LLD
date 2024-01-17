package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import models.City;
import models.Movie;

public class MovieController {

    private final Map<City, List<Movie>> moviesByCity = new HashMap<>();
    @Getter
    private final List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie, City city) {
        movies.add(movie);
        moviesByCity.putIfAbsent(city, new ArrayList<>());
        moviesByCity.get(city).add(movie);
    }

    public void removeMovie(City city, Movie movie) {
        movies.remove(movie);
        moviesByCity.get(city).remove(movie);
    }

    public List<Movie> getMoviesByCity(City city) {
        return moviesByCity.get(city);
    }

}
