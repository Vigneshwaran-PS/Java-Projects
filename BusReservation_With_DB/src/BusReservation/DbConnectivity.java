package BusReservation;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnectivity {

    private final static String url = "jdbc:mysql://localhost:3306/BusReservation";
    private final static String username = "root";
    private final static String password = "0.0.0.";

    public static Connection getConnectivity()throws Exception{
        return DriverManager.getConnection(url,username,password);
    }
}
