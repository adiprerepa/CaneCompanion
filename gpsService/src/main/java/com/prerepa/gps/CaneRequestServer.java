package com.prerepa.gps;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class CaneRequestServer extends Thread {

    static Database db;
    public CaneRequestServer(Database db) {
        this.db = db;
    }

    private Server server;

    @Override
    public void start() {
        int port = 48162;
        try {
            server = ServerBuilder.forPort(port)
                    .addService(new CaneRequestBase())
                    .build()
                    .start();
            System.out.println("Cane Server Started");
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    System.err.println("JVM shutdown, bye");
                    CaneRequestServer.this.stopServer();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void stopServer() {
        if (server != null) {
            server.shutdown();
        }
    }

    public void blockUntilShutdown() throws Throwable {
        if (server != null) {
            server.awaitTermination();
        }
    }

    static class CaneRequestBase extends GpsServiceGrpc.GpsServiceImplBase {

        @Override
        public void caneInsert(CaneCoordinates caneCoordinates, StreamObserver<InsertStatus> responseObserver) {
            double latitude = caneCoordinates.getLatitude();
            double longitude = caneCoordinates.getLongitude();
            String username = caneCoordinates.getUsername();
            int status = db.insertCoordinates(username, latitude, longitude);
            InsertStatus insertStatus = InsertStatus.newBuilder().setInsertStatus(status).build();
            responseObserver.onNext(insertStatus);
            responseObserver.onCompleted();
        }
    }
}
