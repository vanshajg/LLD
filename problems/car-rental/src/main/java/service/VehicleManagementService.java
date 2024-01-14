package service;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import models.Location;
import models.Store;
import models.User;

@Getter
public class VehicleManagementService {

    private final List<User> users = new ArrayList<>();
    private final List<Store> stores = new ArrayList<>();


    public void addStore(Store store) {
        stores.add(store);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void removeStore(Store store) {
        stores.remove(store);
    }

    public User getUser(String userId) {
        return users.get(0);
    }

    public Store getStoreByLocation(Location location) {
        // return geolocation based store
        return stores.get(0);
    }


}
