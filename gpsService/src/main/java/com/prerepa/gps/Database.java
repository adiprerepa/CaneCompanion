package com.prerepa.gps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


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

	public int insertCoordinates(String username, double latitude, double longitude) {
		try {
			Statement stmt = conn.createStatement();
			String insertStatement = String.format("INSERT INTO coordinates(id, username, latitude, longitude) values (null, '%s', %d, %d)", username, Math.round(latitude * 100) / 100, Math.round(longitude * 100) / 100);
			stmt.executeUpdate(insertStatement);
			System.out.println("Insert Successful");
			return 200;
		} catch (Exception e) {
			System.out.println("Something is wrong with the database");
			e.printStackTrace();
			return 1;
		}
	}

	public String retrieveCoordinates(String username, int id) {
		String coordinates = null;
		try {
			Statement stmt = conn.createStatement();
			String retrieveStatement = "SELECT * FROM coordinates";
			ResultSet retrievedResults = stmt.executeQuery(retrieveStatement);

			while (retrievedResults.next()) {
				int tmp1 = retrievedResults.getInt("id");
				String user = retrievedResults.getString("username");
				if (retrievedResults.getInt("id") == id && retrievedResults.getString("username").equals(username)) {
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
