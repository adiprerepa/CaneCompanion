package com.prerepa.accounts;

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

	public boolean userExists(String databaseUsername, String databasePassword, String CaneID) {
		boolean exists = false;
		try {
			Statement stmt = conn.createStatement();
			String getResults = "SELECT username, password, CaneID FROM users";
			ResultSet retrieved = stmt.executeQuery(getResults);

			while (retrieved.next()) {
				String user = retrieved.getString("username");
				String password = retrieved.getString("password");
				String ID = retrieved.getString("CaneID");
				if (user.equals(databaseUsername) && password.equals(databasePassword) && ID.equals(CaneID)) {
					exists = true;
				} else {
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exists;
	}


}
