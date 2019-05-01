package com.prerepa.accounts;


public class Main {

	public static void main(String[] args) {

		String url = "jdbc:mysql://mysqldatabaseinstance.cppavwcwtqiz.us-west-1.rds.amazonaws.com/users";
		String userName = "aditya";
		String password = "adityapc";
		Database db = new Database(url, userName, password);
		AppLoginServer appserver = new AppLoginServer(db);
		System.out.println("Init");
		appserver.start();
	}
}
