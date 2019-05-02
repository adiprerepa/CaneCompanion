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
			User user = new User(userName, password);
			if (userDatabase.userExists(userName, password)) {
				output.writeUTF("Exists");
				System.out.println("Exists");
				user.sendValues(output);
			} else {
				output.writeUTF("No User");
				System.out.println("No User");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
