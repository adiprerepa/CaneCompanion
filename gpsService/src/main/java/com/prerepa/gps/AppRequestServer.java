package com.prerepa.gps;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class AppRequestServer extends Thread {

	static Database db;
	public AppRequestServer(Database db) {
		this.db = db;
	}

	private Server server;

	@Override
	public void start() {
		int port = 23612;
		try {
			server = ServerBuilder.forPort(port)
				.addService(new RequestBase())
				.build()
				.start();
			System.out.println("App Server started");
			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					System.err.println("JVM shutdown, bye");
					AppRequestServer.this.stopServer();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void blockUntilShutdown() throws Throwable {
		if (server != null) {
			server.awaitTermination();
		}
	}

	private void stopServer() {
		if (server != null) {
			server.shutdown();
		}
	}

	static class RequestBase extends GpsServiceGrpc.GpsServiceImplBase {
		@Override
		public void appRetrieve(CoordinatesID coordinatesID, StreamObserver<Coordinates> responseObserver) {

			String username = coordinatesID.getUsername();
			int id = coordinatesID.getCoordinatesID();
			String retrieved = db.retrieveCoordinates(username, id);
			String[] coordinatesAsString = retrieved.split(" ");
			double [] coordinatesInArray = new double[coordinatesAsString.length];
			for (int i = 0; i < coordinatesAsString.length; i++) {
				coordinatesInArray[i] = Double.parseDouble(coordinatesAsString[i]);
			}
			double latitude = coordinatesInArray[0];
			double longitude = coordinatesInArray[1];

			Coordinates coordinates = Coordinates.newBuilder().setLatitude(latitude).setLongitude(longitude).build();

			responseObserver.onNext(coordinates);
			responseObserver.onCompleted();
		}
	}
}

