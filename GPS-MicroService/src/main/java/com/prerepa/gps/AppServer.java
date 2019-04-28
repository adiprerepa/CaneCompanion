package com.prerepa.gps;

import java.net.ServerSocket;
import java.net.Socket;
public class AppServer extends Thread {

	private Database mysqlDb;
	private ServerSocket serverSocket; 

	public AppServer(Database mysqlDb) {
		this.mysqlDb = mysqlDb;
		try {
			serverSocket = new ServerSocket(41256);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Socket tmp = serverSocket.accept();
				AppThread appthread = new AppThread(tmp, mysqlDb);
				appthread.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
