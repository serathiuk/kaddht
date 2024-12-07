package dev.serathiuk.kademlia.server;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KBucketTest {

    private static final String LOCALHOST = "localhost";

    private LocalKademliaNode localKademliaNode;
    private KBucket kBucket;

    @BeforeEach
    void setUp() {
        localKademliaNode = new LocalKademliaNode(LOCALHOST, 9999);

        kBucket = new KBucket(localKademliaNode, NodeRangeBuilder.aNodeRange()
                .withStart(new BigInteger("0"))
                .withEnd(new BigInteger("2").pow(256).subtract(BigInteger.ONE))
                .build(), 0);
    }

    @Test
    void testKBucketWithOneNode() {
        kBucket.addNode(localKademliaNode);
        assertEquals(localKademliaNode.getId(), kBucket.getNearestNode(localKademliaNode.getId()).get().getId());
    }

    @Test
    void testKBucketWithTwoNodes() {
        var node1 = new LocalKademliaNode(LOCALHOST, 8080);
        kBucket.addNode(node1);

        var node2 = new LocalKademliaNode(LOCALHOST, 8081);
        kBucket.addNode(node2);

        assertEquals(node2.getId(), kBucket.getNearestNode(node2.getId()).get().getId());
        assertEquals(node1.getId(), kBucket.getNearestNode(node1.getId()).get().getId());
    }


    @Test
    void testKBucketWithThreeNodes() {
        var node1 = new LocalKademliaNode(LOCALHOST, 8080);
        kBucket.addNode(node1);

        var node2 = new LocalKademliaNode(LOCALHOST, 8081);
        kBucket.addNode(node2);

        var node3 = new LocalKademliaNode(LOCALHOST, 8082);
        kBucket.addNode(node3);

        assertEquals(node2.getId(), kBucket.getNearestNode("chavequalquer").get().getId());
        assertEquals(node2.getId(), kBucket.getNearestNode("testandochave").get().getId());
        assertEquals(node2.getId(), kBucket.getNearestNode("aleatoriamentealeatoria").get().getId());
    }

}