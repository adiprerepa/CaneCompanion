package com.prerepa.accounts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class AccountsDatabase {

    private Connection infoConnection, gpsConnection, wifiConnection, idConnection;

    AccountsDatabase(File constantsFile) {
        BufferedReader br;
        String ip = null;
        String dbUser = null;
        String dbPass = null;
        try {
            br = new BufferedReader(new FileReader(constantsFile));
            ip = br.readLine();
            dbUser = br.readLine();
            dbPass = br.readLine();
            System.out.println(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            infoConnection = DriverManager.getConnection("jdbc:mysql://" + ip + "/userinfo", dbUser, dbPass);
            gpsConnection = DriverManager.getConnection("jdbc:mysql://" + ip + "/usergps", dbUser, dbPass);
            wifiConnection = DriverManager.getConnection("jdbc:mysql://" + ip + "/userwifi", dbUser, dbPass);
            idConnection = DriverManager.getConnection("jdbc:mysql://" + ip + "/usercanes", dbUser, dbPass);
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
