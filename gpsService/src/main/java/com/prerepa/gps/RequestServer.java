package com.prerepa.gps;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class RequestServer extends Thread {

	static GpsDatabase db;
	public RequestServer(GpsDatabase db) {
		RequestServer.db = db;
	}

	private Server server;

	@Override
	public void start() {
		int port = 11612;
		try {
			server = ServerBuilder.forPort(port)
				.addService(new RequestBase())
				.build()
				.start();
			System.out.println("Server started");
			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					System.err.println("JVM shutdown, bye");
					RequestServer.this.stopServer();
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
			CoordinateResponse response = db.retrieveCoordinates(username);
			Coordinates coordinates = Coordinates.newBuilder().addAllLatitude(response.latitudes).addAllLongitude(response.longitudes).build();
			responseObserver.onNext(coordinates);
			responseObserver.onCompleted();
		}

		@Override
		public void caneInsert(CaneCoordinates caneCoordinates, StreamObserver<InsertStatus> insertStatusStreamObserver) {
			double latitude = caneCoordinates.getLatitude();
			double longitude = caneCoordinates.getLongitude();
			String username = caneCoordinates.getUsername();
			int status = db.insertCoordinates(username, latitude, longitude);
			InsertStatus insertStatus = InsertStatus.newBuilder().setInsertStatus(status).build();
			insertStatusStreamObserver.onNext(insertStatus);
			insertStatusStreamObserver.onCompleted();
		}
	}
}

