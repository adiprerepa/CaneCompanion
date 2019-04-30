package com.prerepa.accounts;

import java.net.ServerSocket;
import java.net.Socket

public class AppLoginServer extends Thread {

	Database userDatabase;
	ServerSocket server;
	
	public AppLoginServer(Database userDatabase) {
		this.userDatabase = userDatabase;
		try {
			server = new ServerSocket(31667);
			System.out.println("Waiting for login...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(true) {
			try {
				Socket login = serverSocket.accept();
				AppLoginThread appLogin = new AppLoginThread(login, userDatabase);
				appLogin.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

