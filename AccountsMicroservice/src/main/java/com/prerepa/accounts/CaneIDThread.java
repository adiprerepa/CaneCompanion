package com.prerepa.accounts;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class CaneIDThread extends Thread {

	Socket caneSocket;
	Database caneDB;
	DataInputStream dataInput;
	DataOutputStream dataOutput;

	public CaneIDThread(Socket caneSocket, Database caneDB) {
		this.caneSocket = caneSocket;
		this.caneDB = caneDB;
		try {
			dataInput = new DataInputStream(caneSocket.getInputStream());
			dataOutput = new DataOutputStream(caneSocket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			String claimUser = dataInput.readUTF();
			String caneID = dataInput.readUTF();
			if (caneDB.checkCaneID(claimUser, caneID)) {
				dataOutput.writeUTF("Exists");
			} else {
				dataOutput.writeUTF("Doesn't Exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
