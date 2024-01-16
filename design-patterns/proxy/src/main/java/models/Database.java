package models;

public interface Database {
    void create(String user, String sql) throws Exception;

    void drop(String user, String sql) throws Exception;

    void select(String user, String sql) throws Exception;

}
