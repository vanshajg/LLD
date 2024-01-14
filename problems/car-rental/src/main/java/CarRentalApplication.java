import models.Location;
import models.Store;
import models.User;
import models.VehicleRepository;
import models.product.Car;
import models.product.Vehicle;
import service.VehicleManagementService;

public class CarRentalApplication {
    public static void main(String[] args) {
        VehicleManagementService vehicleManagementService = new VehicleManagementService();

        // -- test data
        addUsers(vehicleManagementService);
        addStores(vehicleManagementService);
        //--------

        User user = vehicleManagementService.getUser("user1");
        Store store = vehicleManagementService.getStoreByLocation(Location.builder().pinCode("pinCode1").build());

        Vehicle vehicle = store.getVehicleRepository().getVehicle();


        store.rentVehicle(user, vehicle);
        store.payBill(user, vehicle);
        store.returnVehicle(user, vehicle);
    }


    private static void addUsers(VehicleManagementService vehicleManagementService) {
        vehicleManagementService.addUser(User.builder()
                .userId("user1")
                .name("user1")
                .build()
        );

        vehicleManagementService.addUser(User.builder()
                .userId("user2")
                .name("user2")
                .build()
        );
    }

    private static void addStores(VehicleManagementService vehicleManagementService) {
        Store store1 = Store.builder()
                .storeId("store1")
                .name("store1")
                .location(Location.builder()
                        .address("address1")
                        .pinCode("pinCode1")
                        .build()
                )
                .vehicleRepository(new VehicleRepository())
                .build();

        store1.getVehicleRepository().addVehicle(Car.builder()
                .id("car1")
                .name("car1")
                .color("color1")
                .number("number1")
                .type(Vehicle.Type.CAR)
                .status(Vehicle.Status.ACTIVE)
                .build()
        );
        vehicleManagementService.addStore(store1);

    }
}
