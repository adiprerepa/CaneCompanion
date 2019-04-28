package com.prerepa.gps;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;

public class CaneServer extends Thread{

	private ServerSocket serverSocket;
	private Database mysqlDb;

	public CaneServer(Database mysqlDb) {
		try {
			serverSocket = new ServerSocket(50051);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.mysqlDb = mysqlDb;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Socket tmp = serverSocket.accept();
				CaneThread cane = new CaneThread(tmp, mysqlDb);
				cane.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
