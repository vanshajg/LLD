package models;

public class DatabaseImpl implements Database {

    @Override
    public void create(String user, String sql) throws Exception {
        System.out.println("User " + user + " created a new record.");
    }

    @Override
    public void drop(String user, String sql) throws Exception {
        System.out.println("User " + user + " dropped a record.");
    }

    @Override
    public void select(String user, String sql) throws Exception {
        System.out.println("User " + user + " selected a record.");
    }
}
