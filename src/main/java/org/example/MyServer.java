package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class MyServer {

    private static final int PORT = 50051;
    private Server server;

    public void start() throws IOException {
        server = ServerBuilder.forPort(PORT)
                .addService(new HelloWorldServiceImpl())     // Register HelloWorld service
                .addService(new ElectionServiceImpl())       // Register Election service
                .build()
                .start();

        System.out.println("Server started, listening on port " + PORT);
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server == null) {
            return;
        }
        server.awaitTermination();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        MyServer server = new MyServer();
        System.out.println("Server is running with both HelloWorld and Election services!");
        server.start();
        server.blockUntilShutdown();
    }

}
