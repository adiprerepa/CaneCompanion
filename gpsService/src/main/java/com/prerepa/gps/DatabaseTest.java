package com.prerepa.gps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseTest {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/usergps?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(url, "aditya", "adityapc");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from aditya_gps");
        while(rs.next()) {
            System.out.printf("%f %f", rs.getDouble("latitude"), rs.getDouble("longitude"));
        }
    }
}
