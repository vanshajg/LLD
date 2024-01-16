import models.Database;
import models.DatabaseProxy;

public class ProxyApplication {
    public static void main(String[] args) {
        Database database = new DatabaseProxy();
        try {
            database.drop("user1", "SELECT * FROM users");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
