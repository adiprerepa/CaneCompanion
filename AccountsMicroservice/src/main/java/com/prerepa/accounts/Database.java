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

	public boolean userExists(User user) {
		boolean exists = false;
		try {
			Statement stmt = conn.createStatement();
			String getResults = "SELECT username, password FROM users";
			ResultSet retrieved = stmt.executeQuery(getResults);

			while (retrieved.next()) {
				String username = retrieved.getString("username");
				String password = retrieved.getString("password");
				if (username.equals(user.username) && password.equals(user.password)) {
					user.setValues(retrieved);
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

	public boolean caneIDExists(String user, String caneID) {
		boolean caneExists = false;
		try {
			Statement caneStatement = conn.createStatement();
			String exec = "SELECT CaneID FROM CaneID";
			ResultSet caneIdRetrieved = caneStatement.executeQuery(exec);
			
			while(caneIdRetrieved.next()) {
				if (caneIdRetrieved.getString("CaneID").equals(caneId) && caneIdRetrieved.getString("Username").equals(user)) {
					caneExists = true
				} else {
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return caneExists;
	}


}
