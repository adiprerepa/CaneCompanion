package com.prerepa.gps;

public class Main {

	public static void main(String[] args) throws Throwable {
		String databaseURL = "jdbc:mysql://localhost/usergps?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "root";
		String password = "adityapc";
		GpsDatabase mysqlDb = new GpsDatabase(databaseURL, username, password);
		AppRequestServer appserver = new AppRequestServer(mysqlDb);
		CaneRequestServer caneserver = new CaneRequestServer(mysqlDb);
//		appserver.start();
		caneserver.start();
//		appserver.blockUntilShutdown();
		caneserver.blockUntilShutdown();
	}
}
