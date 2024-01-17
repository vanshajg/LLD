package models;

import lombok.Builder;

@Builder
public class Booking {
    private String id;
    private String showId;
    private String userId;
    private String seatId;
    private String bookingTime;
    private String status;
    private Payment payment;
}
