import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class Greeter {

    private Server server;

    private void start() throws IOException {
        int port = 35156;
        server = ServerBuilder.forPort(port)
                .addService(new Base())
                .build()
                .start();
        System.out.println("Server started");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("aggaw");
                Greeter.this.stop();
            }
        });

    }

    private void blockUntilShutdown() throws Throwable {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    static class Base extends GreeterGrpc.GreeterImplBase {

        @Override
        public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
            HelloReply rep = HelloReply.newBuilder().setMessage("Yo yo yo" + req.getName()).build();

            responseObserver.onNext(rep);
            responseObserver.onCompleted();
        }
    }
    public static void main(String[] args) throws Throwable {
        final Greeter g = new Greeter();
        g.start();
        g.blockUntilShutdown();
    }
}
