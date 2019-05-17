package com.prerepa.test;

import com.prerepa.gps.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class ClientTest {

	private static final Logger logger = Logger.getLogger(ClientTest.class.getName());
	private final ManagedChannel channel;
	private final GpsServiceGrpc.GpsServiceBlockingStub blockingStub;

	public ClientTest(String host, int port) {
		this(ManagedChannelBuilder.forAddress(host, port)
				.usePlaintext()
				.build());
	}

	public ClientTest(ManagedChannel channel) {
		this.channel = channel;
		blockingStub = GpsServiceGrpc.newBlockingStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public void coordinatesRequest(String username) {
		logger.info("About to send user and id to server...");
		CoordinatesID idRequest = CoordinatesID.newBuilder().setUsername(username).build();
		Coordinates coordinates;
		try {
			coordinates = blockingStub.appRetrieve(idRequest);
		} catch (StatusRuntimeException e) {
			logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
			return;
		}
		List lats = coordinates.getLatitudeList();
		List longs = coordinates.getLongitudeList();
		int stat = coordinates.getStatus();
		Stream.of(lats.toString())
				.forEach(System.out::println);
		Stream.of(longs.toString())
				.forEach(System.out::println);
		System.out.println(stat);

	}

	public void sendCoordinates(double latitude, double longitude, String username) {
		logger.info("About to send latitude and longitude...");
		CaneCoordinates caneCoordinates = CaneCoordinates.newBuilder().setLatitude(latitude).setLongitude(longitude).setUsername(username).build();
		InsertStatus status;
		try {
			status = blockingStub.caneInsert(caneCoordinates);
		} catch (StatusRuntimeException e) {
			e.printStackTrace();
			logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
			return;
		}
		Integer inStatus = status.getInsertStatus();
		logger.info(inStatus.toString());
	}

	public static void main(String[] args) throws Exception {
		ClientTest clientTest = new ClientTest("localhost", 11612);
		try {
			String user = "Aditya";
			int id = 1;
			double latitude = 35.1;
			double longitude = 21.3;
//			clientTest.sendCoordinates(latitude, longitude, user);
			clientTest.coordinatesRequest(user);
		} finally {
			clientTest.shutdown();
		}
	}
}








