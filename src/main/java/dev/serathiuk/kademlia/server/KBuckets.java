package dev.serathiuk.kademlia.server;

import dev.serathiuk.kademlia.server.grpc.Node;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KBuckets {

    private final int maxBucketSize;
    private final KeyService keyService;
    private final Map<Integer, KBucket> buckets;

    public KBuckets(KeyService keyService, int maxBucketSize) {
        this.keyService = keyService;
        this.maxBucketSize = maxBucketSize;

        buckets = IntStream.range(0, keyService.getKeySize())
                .boxed()
                .collect(Collectors.toMap(k -> k, k -> new KBucket(keyService, NodeRange.generate(k), k, maxBucketSize)));
    }

    public void addNode(Node node) {
        getBucket(node.getId()).ifPresent(kBucket -> kBucket.addNode(node));
    }

    public Optional<Node> getNearestNode(String id) {
        return getBucket(id).flatMap(kBucket -> kBucket.getNearestNode(id));
    }

    private Optional<KBucket> getBucket(String id) {
        return buckets.values()
                .stream()
                .filter(kBucket -> kBucket.getNodeRange().containsHash(keyService.hash(id)))
                .findFirst();
    }

    public int getMaxBucketSize() {
        return maxBucketSize;
    }

    public KeyService getKeyService() {
        return keyService;
    }

    public Map<Integer, KBucket> getBuckets() {
        return Collections.unmodifiableMap(buckets);
    }
}
