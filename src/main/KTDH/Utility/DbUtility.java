package KTDH.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtility {
    public static Connection getConnection(){
        try {
            String url = "jdbc:mysql://localhost:3306/ktdh?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "141248690405Zt.";

            Connection c = DriverManager.getConnection(url, user, password);
            System.out.println("ket noi thanh cong!");
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
