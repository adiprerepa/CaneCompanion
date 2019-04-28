package com.prerepa.gps;

import java.net.Socket;
import java.io.DataOutputStream;
import java.io.DataInputStream;

public class AppThread extends Thread {

	private Socket appSocket;
	private DataInputStream dataInput;
	private DataOutputStream dataOutput;
	private Database mysqlDb;

	public AppThread(Socket appSocket, Database mysqlDb) {
		this.appSocket = appSocket;
		this.mysqlDb = mysqlDb;
		try {
			dataInput = new DataInputStream(appSocket.getInputStream());
			dataOutput = new DataOutputStream(appSocket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			int id = dataInput.readInt();
			String username = dataInput.readUTF();
			String coordinates = mysqlDb.retrieveCoordinates(username, id);
			dataOutput.writeUTF(coordinates);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

