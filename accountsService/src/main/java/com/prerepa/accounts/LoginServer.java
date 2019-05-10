package com.prerepa.accounts;

import io.grpc.ServerBuilder;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;

public class LoginServer extends Thread {

    private static AccountsDatabase accountsDatabase;

    LoginServer(AccountsDatabase accountsDatabase) {
        LoginServer.accountsDatabase = accountsDatabase;
    }

    private Server server;

    @Override
    public void run() {
        int port = 39623;
        try {
            server = ServerBuilder.forPort(port)
                    .addService(new LoginRequest())
                    .build()
                    .start();
            System.out.println("Login Server Started");
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    System.err.println("JVM is screwed bye");
                    LoginServer.this.stopServer();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void blockUntilShutdown() throws Throwable {
        if (server != null)
            server.awaitTermination();
    }

    private void stopServer() {
        if (server != null)
            server.shutdown();
    }

    static class LoginRequest extends AccountsServiceGrpc.AccountsServiceImplBase {

        @Override
        public void login(UserCredentials userCredentials, StreamObserver<UserExists> existsStreamObserver) {
            String username = userCredentials.getUsername();
            String password = userCredentials.getPassword();
            boolean userExists = accountsDatabase.login(username, password);
            UserExists exists = UserExists.newBuilder().setUserExists(userExists).build();
            existsStreamObserver.onNext(exists);
            existsStreamObserver.onCompleted();
        }

        @Override
        public void register(UserRegisterInfo registerInfo, StreamObserver<RegisterSuccessful> successfulStreamObserver) {
            String username = registerInfo.getUsername();
            String password = registerInfo.getPassword();
            String email = registerInfo.getEmail();
            String phoneNumber = registerInfo.getPhone();
            String name = registerInfo.getName();
            int age = registerInfo.getAge();
            boolean registerStatus = accountsDatabase.register(username, password, phoneNumber, email, name, age);
            RegisterSuccessful registerSuccessful = RegisterSuccessful.newBuilder().setSuccess(registerStatus).build();
            successfulStreamObserver.onNext(registerSuccessful);
            successfulStreamObserver.onCompleted();
        }

    }

}
