package dev.serathiuk.kademlia.server;

import dev.serathiuk.kademlia.server.grpc.Node;
import org.assertj.core.api.Assertions;
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
        var node = Node.newBuilder()
                .setId(keyService.generateId("localhost", 8080))
                .setPort(8080)
                .setHost("localhost")
                .build();

        kBuckets.addNode(node);

        var node2 = Node.newBuilder()
                .setId(keyService.generateId("localhost", 8081))
                .setPort(8081)
                .setHost("localhost")
                .build();

        kBuckets.addNode(node2);

        var node3 = Node.newBuilder()
                .setId(keyService.generateId("localhost", 8079))
                .setPort(8079)
                .setHost("localhost")
                .build();

        kBuckets.addNode(node3);

        var bucket1 = kBuckets.getBuckets().get(254);
        var bucket2 = kBuckets.getBuckets().get(255);

        assertEquals(2, bucket1.getNodes().size());
        assertEquals(1, bucket2.getNodes().size());

        Assertions.assertThat(bucket1.getNodes()).contains(node, node2);
        Assertions.assertThat(bucket2.getNodes()).contains(node3);
    }

}