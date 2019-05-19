package com.prerepa.test;

import com.prerepa.gps.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class GpsClient {
    private static final Logger logger = Logger.getLogger(GpsClient.class.getName());
    private final ManagedChannel channel;
    private GpsServiceGrpc.GpsServiceBlockingStub blockingStub;

    GpsClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build());
    }

    GpsClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = GpsServiceGrpc.newBlockingStub(channel);
    }

    void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    void getCoordinatesRequest(String username) {
        logger.info("About to ask for coordinates, giving username to server");
        CoordinatesID id = CoordinatesID.newBuilder().setUsername(username).build();
        Coordinates coordinates;
        coordinates = blockingStub.appRetrieve(id);
        List latitudes = coordinates.getLatitudeList();
        List longitudes = coordinates.getLongitudeList();
        int status = coordinates.getStatus();
        Stream.of(latitudes.toString())
                .forEach(System.out::println);
        Stream.of(longitudes.toString())
                .forEach(System.out::println);
        System.out.println(status);
    }

    public static void main(String[] args) throws Exception {
        GpsClient gpsClient = new GpsClient("localhost", 11612);
        try {
            String user = "aditya";
            gpsClient.getCoordinatesRequest(user);
        } finally {
            gpsClient.shutdown();
        }
    }
}
