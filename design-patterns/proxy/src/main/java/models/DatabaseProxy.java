package models;

public class DatabaseProxy implements Database {

    private final Database database;

    public DatabaseProxy() {
        this.database = new DatabaseImpl();
    }

    @Override
    public void create(String user, String sql) throws Exception {
        if (user.equals("admin")) {
            database.create(user, sql);
        } else {
            throw new Exception("Only admin can create.");
        }
    }

    @Override
    public void drop(String user, String sql) throws Exception {
        if (user.equals("admin")) {
            database.drop(user, sql);
        } else {
            throw new Exception("Only admin can drop.");
        }
    }

    @Override
    public void select(String user, String sql) throws Exception {
        database.select(user, sql);
    }
}
