package com.prerepa.accounts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class AccountsDatabase {

    private Connection infoConnection, gpsConnection, wifiConnection, idConnection;

    AccountsDatabase(String databaseUsername, String databasePassword) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            infoConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/userinfo", databaseUsername, databasePassword);
            gpsConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/usergps", databaseUsername, databasePassword);
            wifiConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/userwifi", databaseUsername, databasePassword);
            idConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/usercanes", databaseUsername, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    boolean register(String registerUsername, String registerPassword, String registerPhoneNumber,
                            String registerEmail, String registerName, int age) {
        boolean regStatus = true;
        try {
            Statement stmt = infoConnection.createStatement();
            String checkUserStatement = "select * from users";
            ResultSet resultSet = stmt.executeQuery(checkUserStatement);
            while(resultSet.next()) {
                if (resultSet.getString("username").equals(registerUsername)){
                    regStatus = false;
                    break;
                }
            }
            if (regStatus) {
                String createUserWifiTable = "CREATE TABLE " + registerUsername + "_wifi (ssid varchar(60), password varchar(60), ip varchar(40));";
                String createUserCaneTable = "CREATE TABLE " + registerUsername + "_canes (caneID varchar(60))";
                String createUserGpsTable = "CREATE TABLE " + registerUsername + "_gps (latitude decimal(6,2), longitude decimal(6,2), timestamp varchar(50));";
                Statement wifiStmt = wifiConnection.createStatement();
                Statement caneStmt = idConnection.createStatement();
                Statement gpsStmt = gpsConnection.createStatement();
                wifiStmt.executeQuery(createUserWifiTable);
                caneStmt.executeQuery(createUserCaneTable);
                gpsStmt.executeQuery(createUserGpsTable);
                System.out.println("Created all tables for user " + registerUsername);
                String insertValues = "INSERT INTO users (username, password, user_name, email, phoneNumber, age) values (" + registerUsername + ", " + registerPassword + ", " + registerName + ", " + registerEmail + ", " + registerPhoneNumber + ", " + age + ");";
                stmt.executeQuery(insertValues);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regStatus;
    }

    boolean login(String username, String password) {
        boolean userExists = false;
        String loginQuery = "SELECT username, password FROM users";
        try {
            Statement loginStatement = infoConnection.createStatement();
            ResultSet rs = loginStatement.executeQuery(loginQuery);
            while (rs.next()) {
                if (rs.getString("username").equals(username) && rs.getString("password").equals(password)) {
                    userExists = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userExists;
    }

}
