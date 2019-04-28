package com.prerepa.gps;

import java.sql.*;


public class Database {

	private String databaseUrl;
	private String username;
	private String password;
	private Connection conn;
	
	public Database(String databaseUrl, String username, String password) {
		this.databaseUrl = databaseUrl;
		this.username = username;
		this.password = password;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseUrl, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertCoordinates(int latitude, int longitude) {
		try {
			Statement stmt = conn.createStatement();
			String insertStatement = String.format("INSERT INTO coordinates(id, latitude, longitude) values (null, %d, %d)", latitude, longitude);
			stmt.executeUpdate(insertStatement);
			System.out.println("Insert Successful");
		} catch (Exception e) {
			System.out.println("Something is wrong with the database");
			e.printStackTrace();
		}
	}

	public String retrieveCoordinates(int id) {
		String coordinates = null;
		try {
			Statement stmt = conn.createStatement();
			String retrieveStatement = "SELECT id, latitude, longitude FROM coordinates";
			ResultSet retrievedResults = stmt.executeQuery(retrieveStatement);

			while (retrievedResults.next()) {
				if (retrievedResults.getInt("id") == id) {
					Integer latitude = retrievedResults.getInt("latitude");
					Integer longitude = retrievedResults.getInt("longitude");
					coordinates = String.format("%s %s", latitude.toString(), longitude.toString());
				} else {
					System.err.println("There was no records for the id provided");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coordinates;
	}
}
