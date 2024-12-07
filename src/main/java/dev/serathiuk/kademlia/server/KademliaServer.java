package dev.serathiuk.kademlia.server;

import dev.serathiuk.kademlia.server.grpc.*;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class KademliaServer extends KademliaGrpc.KademliaImplBase implements Runnable {

    private LocalKademliaNode rootNode;
    private KBuckets kBuckets;
    private Server server;

    private boolean started = false;

    public KademliaServer() {
        this.rootNode = new LocalKademliaNode("localhost", 8080);
        this.kBuckets = new KBuckets(rootNode);
    }

    @Override
    public void run() {
        try {
            // TODO Create port config
            server = Grpc.newServerBuilderForPort(8080, InsecureServerCredentials.create())
                    .addService(this)
                    .keepAliveTime(60, TimeUnit.SECONDS)  // Tempo entre verificações de keepalive
                    .keepAliveTimeout(120, TimeUnit.SECONDS)
                    .build()
                    .start();

            // TODO Create node config
//            System.out.println("Server started, listening on " + node.getHost()+":"+node.getPort());

            // Shutdown hook para fechar o servidor corretamente
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.err.println("** Servidor encerrado via shutdown hook **");
//                shutdownNow();
            }));

            started = true;

            server.awaitTermination();
        } catch (InterruptedException | IOException e) {
            //TODO Vericar no
//            System.err.println( "Node "+node.getId());
            e.printStackTrace();
        }
    }

    @Override
    public void findNode(NodeId request, StreamObserver<Node> responseObserver) {
        super.findNode(request, responseObserver);
    }

    @Override
    public void ping(NodeId request, StreamObserver<NodeId> responseObserver) {
        super.ping(request, responseObserver);
    }

    @Override
    public void store(Entry request, StreamObserver<StoreResponse> responseObserver) {
        super.store(request, responseObserver);
    }

    @Override
    public void findValue(FindValueRequest request, StreamObserver<FindValueResponse> responseObserver) {
        super.findValue(request, responseObserver);
    }

    public void shutdownNow() {
        server.shutdownNow();
    }

}