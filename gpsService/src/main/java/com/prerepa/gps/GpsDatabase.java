package com.prerepa.gps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GpsDatabase {

    private Connection gpsConnection;

    GpsDatabase(String url, String databaseUsername, String databasePassword) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            gpsConnection = DriverManager.getConnection(url, databaseUsername, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insertCoordinates(String username, double latitude, double longitude) {
        try {
            Statement stmt = gpsConnection.createStatement();
            String insertStatement = String.format("INSERT INTO %s (latitude, longitude) values (%d, %d)", username, Math.round(latitude * 100) / 100, Math.round(longitude * 100) / 100);
            stmt.executeUpdate(insertStatement);
            System.out.println("Insert Successful");
            return 200;
        } catch (Exception e) {
            System.out.println("Fuck");
            e.printStackTrace();
            return 1;
        }
    }

    public CoordinateResponse retrieveCoordinates(String username) {
        /**
         * TODO : Return coodinatesresp and call as repeated in proto to handoff o app
         */
        String coordinates = null;
        try {
            Statement stmt = gpsConnection.createStatement();
            String retrieveStatement = "SELECT * FROM " + username;
            ResultSet retrievedResults = stmt.executeQuery(retrieveStatement);

            while (retrievedResults.next()) {

                if (retrievedResults.getString("username").equals(username)) {
                    Double latitude = retrievedResults.getDouble("latitude");
                    Double longitude = retrievedResults.getDouble("longitude");
                    coordinates = String.format("%s %s", latitude.toString(), longitude.toString());
                } else {
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coordinates;
    }

}
