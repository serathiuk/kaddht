package dev.serathiuk.kademlia.server;

import dev.serathiuk.kademlia.server.grpc.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class KBucketTest {

    private static final String LOCALHOST = "localhost";

    private final KeyService keyService = new KeyService(256);
    private KBucket kBucket;

    @BeforeEach
    void setUp() {
        kBucket = new KBucket(keyService, NodeRangeBuilder.aNodeRange()
                .withStart(new BigInteger("0"))
                .withEnd(new BigInteger("255"))
                .build(), 2);
    }

    @Test
    void testKBucketWithOneNode() {
        Node node = Node.newBuilder()
                .setId(keyService.generateId(LOCALHOST, 8080))
                .setHost(LOCALHOST)
                .setPort(8080)
                .build();

        kBucket.addNode(node);
        assertEquals(node.getId(), kBucket.getNearestNode("teste").get().getId());
    }

    @Test
    void testKBucketWithTwoNodes() {
        Node node1 = Node.newBuilder()
                .setId(keyService.generateId(LOCALHOST, 8080))
                .setPort(8080)
                .setHost(LOCALHOST)
                .build();

        kBucket.addNode(node1);

        Node node2 = Node.newBuilder()
                .setId(keyService.generateId(LOCALHOST, 8081))
                .setHost(LOCALHOST)
                .setPort(8081)
                .build();

        kBucket.addNode(node2);

        assertEquals(node2.getId(), kBucket.getNearestNode("teste1").get().getId());
        assertEquals(node2.getId(), kBucket.getNearestNode("teste2").get().getId());
        assertEquals(node2.getId(), kBucket.getNearestNode("teste3").get().getId());
    }


    @Test
    void testKBucketWithThreeNodes() {
        Node node1 = Node.newBuilder()
                .setId(keyService.generateId(LOCALHOST, 8080))
                .setPort(8080)
                .setHost(LOCALHOST)
                .build();
        kBucket.addNode(node1); // add 1

        Node node2 = Node.newBuilder()
                .setId(keyService.generateId(LOCALHOST, 8081))
                .setPort(8081)
                .setHost(LOCALHOST)
                .build();
        kBucket.addNode(node2); //add 2

        Node node3 = Node.newBuilder()
                .setId(keyService.generateId(LOCALHOST, 8082))
                .setPort(8082)
                .setHost(LOCALHOST)
                .build();
        kBucket.addNode(node3); // 1 removed and 3 added

        assertEquals(node2.getId(), kBucket.getNearestNode("teste1").get().getId());
        assertEquals(node2.getId(), kBucket.getNearestNode("teste2").get().getId());
        assertEquals(node2.getId(), kBucket.getNearestNode("teste3").get().getId());
    }

}