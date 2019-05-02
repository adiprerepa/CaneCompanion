package com.prerepa.accounts;

import java.net.ServerSocket;
import java.net.Socket;

public class CaneIDServer extends Thread {
	
	ServerSocket caneServer;
	Database database;

	public CaneIDServer(Database database) {
		this.database = database;
		try {
			caneServer = new ServerSocket(35362);
			System.out.println("Waiting for Cane Prompt...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

	@Override
	public void run() {
		Socket idSocket = caneServer.accept();
		CaneIDThread ct = new CaneIDThread(idSocket, database);
		ct.start();
	}
}
