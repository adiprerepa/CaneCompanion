package com.prerepa.accounts;

import java.sql.ResultSet;
import java.io.DataOutputStream;

public class User {
	
	String userName;
	String password;
	String caneID;
	String Name;
	int age;
	String caneModel;
	String InitialWiFiSsid;
	String InitialWiFiPass;
	String IPaddr;

	public User(String userName, String password, String caneID) {
		this.userName = userName;
		this.password = password;
		this.caneID = caneID;
	}

	public void setValues(ResultSet retrieved) throws Exception {
		while(retrieved.next()) {
			if (retrieved.getString("username").equals(userName)) {
				Name = retrieved.getString("Name");
				age = retrieved.getInt("age");
				caneModel = retrieved.getString("caneModel");
				InitialWiFiSsid = retrieved.getString("InitialWiFiSsid");
				InitialWiFiPass = retrieved.getString("InitialWifiPass");
				IPaddr = retrieved.getString("IPaddr");
			} else {
				continue;
			}
		}
	}

	public void sendValues(DataOutputStream output) throws Exception {
		output.writeUTF(Name);
		output.writeInt(age);
		output.writeUTF(caneModel);
		output.writeUTF(InitialWiFiSsid);
		output.writeUTF(InitialWiFiPass);
		output.writeUTF(IPaddr);
	}
}
