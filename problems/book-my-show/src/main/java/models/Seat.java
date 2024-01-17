package models;

import lombok.Builder;

@Builder
public class Seat {
    private String id;
    private int row;
    private int column;
    private SeatType seatType;

    public enum SeatType {
        REGULAR,
        PREMIUM,
        ACCESSIBLE,
        SHIPPED,
        EMERGENCY_EXIT,
        OTHER
    }
}
