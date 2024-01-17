package models;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Show {

    private String id;
    private Movie movie;
    private String startTime;
    private String endTime;
    private String screenId;
    private String theatreId;
    private final List<String> bookedSeatIds = new ArrayList<>();
    private final List<Booking> bookings = new ArrayList<>();
}
