package models;

import lombok.Getter;

@Getter
public class Reservation {
    private final String reservationId;
    private final String userId;
    private final String vehicleId;
    private final Bill bill;

    public Reservation(String userId, String vehicleId) {
        this.reservationId = "reservationId";
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.bill = new Bill(12.0);
    }

}
