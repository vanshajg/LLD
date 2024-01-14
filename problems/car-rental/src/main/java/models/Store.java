package models;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import models.product.Vehicle;

@Builder
@Data
public class Store {

    private String storeId;
    private String name;
    private Location location;
    private VehicleRepository vehicleRepository;
    private final List<Reservation> reservations = new ArrayList<>();

    public void rentVehicle(User user, Vehicle vehicle) {
        vehicle.setStatus(Vehicle.Status.INACTIVE);
        Reservation reservation = new Reservation(user.getUserId(), vehicle.getId());
        reservations.add(reservation);
        System.out.println("Vehicle rented successfully by user: " + user.getUserId());
    }

    public Reservation getReservation(String userId, String vehicleId) {
        return reservations.stream()
                .filter(r -> r.getUserId().equals(userId) && r.getVehicleId().equals(vehicleId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No reservation found for user: " + userId + " and vehicle: " + vehicleId));
    }

    public void payBill(User user, Vehicle vehicle) {
        Reservation reservation = getReservation(user.getUserId(), vehicle.getId());
        Bill bill = reservation.getBill();
        bill.payBill("123", "CASH");
        System.out.println("Bill paid successfully for vehicle: " + vehicle.getId() + " by user: " + user.getUserId());
    }

    public void returnVehicle(User user, Vehicle vehicle) {
        // check if bill is paid
        Reservation reservation = getReservation(user.getUserId(), vehicle.getId());
        if (!reservation.getBill().getIsPaid()) {
            throw new RuntimeException("Bill not paid for vehicle: " + vehicle.getId());
        }
        vehicle.setStatus(Vehicle.Status.ACTIVE);
        reservations.remove(reservation);
        System.out.println("Vehicle returned successfully by user: " + user.getUserId());
    }


}
