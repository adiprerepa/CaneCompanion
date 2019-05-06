package com.prerepa.gps;

public class Main {

	public static void main(String[] args) throws Throwable {
		String databaseURL = "jdbc:mysql://mysqldatabaseinstance.cppavwcwtqiz.us-west-1.rds.amazonaws.com/users";
		String username = "aditya";
		String password = "adityapc";
		Database mysqlDb = new Database(databaseURL, username, password);
		AppRequestServer appserver = new AppRequestServer(mysqlDb);
		CaneRequestServer caneserver = new CaneRequestServer(mysqlDb);
		appserver.start();
		caneserver.start();
		appserver.blockUntilShutdown();
		caneserver.blockUntilShutdown();
	}
}
