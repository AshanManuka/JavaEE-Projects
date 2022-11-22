package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    private static dbConnection dbconnection = null;
    private Connection connection;

    private dbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/d4", "root", "1234");
    }

    public static dbConnection getInstance() throws SQLException, ClassNotFoundException {
//        return (dbconnection==null)? dbconnection= new dbConnection(): dbconnection;
        if (dbconnection == null){
            dbconnection = new dbConnection();
            return dbconnection;
        }
        return dbconnection;
    }

    public Connection getConnection() {
        return connection;
    }


}
