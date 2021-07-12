package connection;

import java.sql.*;

public class SQLConnection {

    private static final String URI = "jdbc:postgresql://localhost/postgres";
    private static final String USER = "postgres";
    private static final String PWD = "root";

    public void startConnection() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
        System.out.println("Rodou");
    }

    public Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(URI, USER, PWD);
    }

    public void closeConnection() throws SQLException {
        this.getConnection().close();
    }
}
