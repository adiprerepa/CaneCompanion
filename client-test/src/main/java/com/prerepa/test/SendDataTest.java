package com.prerepa.test;

import com.prerepa.gps.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SendDataTest {

    ManagedChannel channel;
    GpsServiceGrpc.GpsServiceBlockingStub stub;

    SendDataTest(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
    }

    SendDataTest(ManagedChannel channel) {
        this.channel = channel;
        stub = GpsServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    void send(double lat, double longit, String user) {
        System.out.println("Gna send stuff");
        CaneCoordinates req = CaneCoordinates.newBuilder().setLatitude(lat).setLongitude(longit).setUsername(user).build();
        InsertStatus stat = null;
        try {
            stat = stub.caneInsert(req);
        } catch (StatusRuntimeException e) {
            e.printStackTrace();
        }

        int in = stat.getInsertStatus();
        System.out.println(in);
    }

    public static void main(String[] args) {
        SendDataTest d = new SendDataTest("localhost", 48162);
        try {
            d.send(52.3, 54.2, "Aditya");
        } finally {
            try {
                d.shutdown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
