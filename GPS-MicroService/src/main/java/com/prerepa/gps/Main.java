package com.prerepa.gps;

public class Main {

	public static void main(String[] args) {
		String databaseUrl = "jdbc:mysql://13.57.106.230/coordinates";
                String username = "adi";
                String password = "adirocks";
                Database mysqlDb = new Database(databaseUrl, username, password);

		CaneServer caneserver = new CaneServer(mysqlDb);
		AppServer appserver = new AppServer(mysqlDb);
		caneserver.start();
		System.out.println("Started cane server");
		appserver.start();
		System.out.println("Started App Server");
	}
}
