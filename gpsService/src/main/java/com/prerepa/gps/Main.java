package com.prerepa.gps;

public class Main {

	public static void main(String[] args) throws Throwable {
		String databaseURL = "jdbc:mysql://localhost/usergps?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "aditya";
		String password = "adityapc";
		GpsDatabase mysqlDb = new GpsDatabase(databaseURL, username, password);
		RequestServer server = new RequestServer(mysqlDb);
		server.start();
		server.blockUntilShutdown();
	}
}
