package com.prerepa.accounts;

import java.net.Socket;
import java.io.DataOutputStream;
import java.io.DataInputStream;

public class AppLoginThread {

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

	}
