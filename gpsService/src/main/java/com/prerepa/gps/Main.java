package com.prerepa.gps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws Throwable {
		BufferedReader br;
		String ip = null;
		String dbUser = null;
		String dbPass = null;
		try {
			br = new BufferedReader(new FileReader("/home/aditya/CaneCompanion/ipAddrs"));
			ip = br.readLine();
			dbUser = br.readLine();
			dbPass = br.readLine();
			System.out.println(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String databaseURL = "jdbc:mysql://" + ip + "/usergps?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		GpsDatabase mysqlDb = new GpsDatabase(databaseURL, dbUser, dbPass);
		RequestServer server = new RequestServer(mysqlDb);
		server.start();
		server.blockUntilShutdown();
	}
}
