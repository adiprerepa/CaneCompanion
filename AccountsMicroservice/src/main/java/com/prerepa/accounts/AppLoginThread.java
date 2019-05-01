package com.prerepa.accounts;

import java.net.Socket;
import java.io.DataOutputStream;
import java.io.DataInputStream;

public class AppLoginThread extends Thread {

	private Database userDatabase;
	private Socket login;
	private DataOutputStream output;
	private DataInputStream input;

	public AppLoginThread(Socket login, Database userDatabase) {
		this.login = login;
		this.userDatabase = userDatabase;
		try {
			input = new DataInputStream(login.getInputStream());
			output = new DataOutputStream(login.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			String userName = input.readUTF();
			String password = input.readUTF();
			String caneID = input.readUTF();
			if (userDatabase.userExists(userName, password, caneID)) {
				System.out.println("Exists");
			} else {
				System.out.println("Something worong");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
