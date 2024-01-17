import static java.util.Objects.isNull;

import java.util.List;

import controllers.MovieController;
import controllers.TheatreController;
import models.Booking;
import models.City;
import models.Movie;
import models.Payment;
import models.Show;
import models.Theatre;

public class BMSApplication {

    private final MovieController movieController = new MovieController();
    private final TheatreController theatreController = new TheatreController();

    private void init() {
        Movie movie1 = Movie.builder().id("1").name("The Dark Knight").build();
        Movie movie2 = Movie.builder().id("2").name("Avengers").build();
        movieController.addMovie(movie1, City.DELHI);
        movieController.addMovie(movie2, City.DELHI);
        movieController.addMovie(movie1, City.MUMBAI);

        Theatre theatre1 = Theatre.builder().id("1")
                .name("PVR")
                .shows(List.of(Show.builder().movie(movie1).build()))
                .build();
        Theatre theatre2 = Theatre.builder().id("2")
                .shows(List.of(Show.builder().movie(movie1).build(), Show.builder().movie(movie2).build()))
                .build();
        Theatre theatre3 = Theatre.builder().id("3")
                .shows(List.of(Show.builder().movie(movie1).build()))
                .build();
        theatreController.addTheatre(theatre1, City.DELHI);
        theatreController.addTheatre(theatre2, City.DELHI);
        theatreController.addTheatre(theatre3, City.MUMBAI);
    }

    private void createBooking(final City city, final String movieName) {
        List<Movie> moviesByCity = movieController.getMoviesByCity(city);
        Movie movie = moviesByCity.stream().filter(m -> m.getName().equals(movieName)).findFirst().orElse(null);
        if (isNull(movie)) {
            throw new RuntimeException("Movie not found");
        }

        Theatre theatre = theatreController.getTheatresByMovie(city, movie).get(0);
        Show show = theatre.getShows().stream().filter(s -> s.getMovie().equals(movie)).findFirst().orElse(null);
        if (isNull(show)) {
            throw new RuntimeException("Show not found");
        }

        String bookedSeatId = "seat23";
        if (show.getBookedSeatIds().contains(bookedSeatId)) {
            throw new RuntimeException("Seat already booked");
        }
        Booking booking = Booking.builder().seatId(bookedSeatId)
                .payment(Payment.builder().amount("100").build())
                .build();
        show.getBookedSeatIds().add(bookedSeatId);
        show.getBookings().add(booking);
        System.out.println("Booking successful");
    }

    public static void main(String[] args) {
        BMSApplication bmsApplication = new BMSApplication();
        bmsApplication.init();

        bmsApplication.createBooking(City.DELHI, "The Dark Knight");
        bmsApplication.createBooking(City.MUMBAI, "The Dark Knight");
    }
}
