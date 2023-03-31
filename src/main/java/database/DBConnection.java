package database;

import java.sql.*;

public class DBConnection {

    private static DBConnection instance;
    private Connection connection;
    private String url = "";
    private String username =  System.getProperty("dbLogin");
    private String password = System.getProperty("dbPassword");
    private String dbHost = System.getProperty("dbHost");
    private String dbName = System.getProperty("dbName");

    private DBConnection() throws SQLException {
        url = String.format("jdbc:mariadb://%1$s/%2$s",dbHost, dbName);
        this.connection = DriverManager.getConnection(url, username, password);
        this.connection.setAutoCommit(true);
    }

    public Connection getConnection(){
        return connection;
    }

    public static DBConnection getInstance() throws SQLException {
        if(instance == null){
            instance = new DBConnection();

        } else if(instance.getConnection().isClosed()){
            instance = new DBConnection();
        }

        return instance;
    }
}
