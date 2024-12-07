package dev.serathiuk.kademlia.server;

import dev.serathiuk.kademlia.server.grpc.Node;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KBucketsTest {

    private final LocalKademliaNode localKademliaNode = new LocalKademliaNode("localhost", 9999);


    @Test
    void getBuckets() {
        var kBuckets = new KBuckets(localKademliaNode);
        assertEquals(256, kBuckets.getBuckets().size());

        for (int i = 0; i < 256; i++) {
            assertTrue(kBuckets.getBuckets().containsKey(i));
        }

        for(var entry : kBuckets.getBuckets().entrySet()) {
            var kBucket = entry.getValue();

            var expectedRange = NodeRange.generate(entry.getKey());
            var actualRange = kBucket.getNodeRange();
            assertEquals(expectedRange.hashStart(), actualRange.hashStart());
            assertEquals(expectedRange.hashEnd(), actualRange.hashEnd());
        }
    }

    @Test
    void testAddNode() {
        var kBuckets = new KBuckets(localKademliaNode);

        var node = new LocalKademliaNode("serathiuk.dev", 1000);
        kBuckets.addNode(node);

        var node2 = new LocalKademliaNode("serathi.uk", 5000);
        kBuckets.addNode(node2);

        var node3 = new LocalKademliaNode("serathiuk.com", 10000);
        kBuckets.addNode(node3);

        var node4 = new LocalKademliaNode("serathiuk.com.br", 15000);
        kBuckets.addNode(node4);

        var bucket1 = kBuckets.getBuckets().get(251);
        var bucket2 = kBuckets.getBuckets().get(254);

        assertEquals(2, bucket1.getNodes().size());
        assertEquals(1, bucket2.getNodes().size());

        Assertions.assertThat(bucket1.getNodes()).contains(node2, node3);
        Assertions.assertThat(bucket2.getNodes()).contains(node4);
    }

}