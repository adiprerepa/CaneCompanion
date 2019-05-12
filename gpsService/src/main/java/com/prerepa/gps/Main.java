package com.prerepa.gps;

public class Main {

	public static void main(String[] args) throws Throwable {
		String databaseURL = "jdbc:mysql://10.0.1.16/usergps?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "root";
		String password = "adityapc";
		GpsDatabase mysqlDb = new GpsDatabase(databaseURL, username, password);
		RequestServer server = new RequestServer(mysqlDb);
		server.start();
		server.blockUntilShutdown();
	}
}
