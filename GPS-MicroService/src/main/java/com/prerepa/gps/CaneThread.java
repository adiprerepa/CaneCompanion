package com.prerepa.gps;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.InputStream;

public class CaneThread extends Thread {

	// write app thread on another thread and pull directly from database
	// initialize thread same way as CaneThread
	private Socket caneSocket;
	private DataInputStream dataStream;
	private Database mysqlDb;

	public CaneThread(Socket caneSocket, Database mysqlDb) {
		this.caneSocket = caneSocket;	
	        this.mysqlDb = mysqlDb;
	        try {
			dataStream = new DataInputStream(caneSocket.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			int latitude = dataStream.readInt();
			int longitude = dataStream.readInt();
			mysqlDb.insertCoordinates(latitude, longitude);
			System.out.println("Recieved and inserted coordinates");
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
}
