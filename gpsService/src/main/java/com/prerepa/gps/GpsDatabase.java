package com.prerepa.gps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class GpsDatabase {

    private Connection gpsConnection;

    GpsDatabase(String url, String databaseUsername, String databasePassword) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            gpsConnection = DriverManager.getConnection(url, databaseUsername, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int insertCoordinates(String username, double latitude, double longitude) {
        try {
            Statement stmt = gpsConnection.createStatement();
            String insertStatement = String.format("INSERT INTO %s (latitude, longitude) values (%f, %f)", username, Math.round(latitude * 100) / 100, Math.round(longitude * 100) / 100);
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
        CoordinateResponse returnResp = new CoordinateResponse();
        try {
            Statement stmt = gpsConnection.createStatement();
            String retrieveStatement = "SELECT * FROM " + username + "_gps";
            //String retrieveStatement = "SELECT * FROM aditya_gps";
            ResultSet retrievedResults = stmt.executeQuery(retrieveStatement);

            while (retrievedResults.next()) {
                Double latitude = retrievedResults.getDouble("latitude");
                Double longitude = retrievedResults.getDouble("longitude");
//                System.out.println(latitude);
//                System.out.println(longitude);
//                System.out.printf("%f %f", latitude, longitude);
                returnResp.latitudes.add(latitude);
                returnResp.longitudes.add(longitude);
                returnResp.pullStatus = 200;
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnResp.pullStatus = 1;
        }
        return returnResp;
    }

}
