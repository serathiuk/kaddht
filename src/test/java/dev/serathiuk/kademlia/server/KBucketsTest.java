package dev.serathiuk.kademlia.server;

import dev.serathiuk.kademlia.server.grpc.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KBucketsTest {

    KeyService keyService;

    @BeforeEach
    void setUp() {
        keyService = new KeyService(256);
    }

    @Test
    void getMaxBucketSize() {
        int maxBucketSize = 2;
        var kBucket = new KBuckets(keyService, maxBucketSize);
        assertEquals(maxBucketSize, kBucket.getMaxBucketSize());
    }

    @Test
    void getKeyService() {
        var kBucket = new KBuckets(keyService, 2);
        assertEquals(keyService, kBucket.getKeyService());
    }

    @Test
    void getBuckets() {
        var kBuckets = new KBuckets(keyService, 2);
        assertEquals(256, kBuckets.getBuckets().size());

        for (int i = 0; i < 256; i++) {
            assertTrue(kBuckets.getBuckets().containsKey(i));
        }

        for(var entry : kBuckets.getBuckets().entrySet()) {
            var kBucket = entry.getValue();
            assertEquals(2, kBucket.getMaxBucketSize());
            assertEquals(keyService, kBucket.getKeyService());

            var expectedRange = NodeRange.generate(entry.getKey());
            var actualRange = kBucket.getNodeRange();
            assertEquals(expectedRange.hashStart(), actualRange.hashStart());
            assertEquals(expectedRange.hashEnd(), actualRange.hashEnd());
        }
    }

    @Test
    void testAddNode() {
        var kBuckets = new KBuckets(keyService, 2);
        var node = Node.newBuilder().setId("1").build();
        kBuckets.addNode(node);

        var kBucket = kBuckets.getBuckets().get(0);
        assertEquals(1, kBucket.getNodes().size());
        assertEquals(node, kBucket.getNodes().get(0));
    }

}