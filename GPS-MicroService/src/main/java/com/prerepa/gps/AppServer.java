package com.prerepa.gps;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class AppServer extends Thread {

	private Database mysqlDb;
	private ServerSocket serverSocket;
	private Server server;

	public AppServer(Database mysqlDb) {
		this.mysqlDb = mysqlDb;
		try {
			serverSocket = new ServerSocket(41256);
			System.out.println("Waiting for App Server connections...");
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
//	}
//
//	private void start(int port) {
//		server = ServerBuilder.forPort(port)
//				.addService()
//	}
	}
}
