package dev.serathiuk.kademlia.server;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KBuckets {

    private LocalKademliaNode rootNode;
    private final Map<Integer, KBucket> buckets;

    public KBuckets(LocalKademliaNode rootNode) {
        this.rootNode = rootNode;

        buckets = IntStream.range(0, KademliaNode.KEY_SIZE)
                .boxed()
                .collect(Collectors.toMap(k -> k, k -> new KBucket(rootNode, NodeRange.generate(k), k)));
    }

    public void addNode(KademliaNode node) {
        getBucket(node).ifPresent(kBucket -> kBucket.addNode(node));
    }

    public Optional<KademliaNode> getNearestNode(KademliaNode node) {
        return getBucket(node).flatMap(kBucket -> kBucket.getNearestNode(node.getId()));
    }

    private Optional<KBucket> getBucket(KademliaNode node) {
        return buckets.values()
                .stream()
                .filter(kBucket -> kBucket.getNodeRange().containsHash(node.getDistance(rootNode)))
                .findFirst();
    }

    public Map<Integer, KBucket> getBuckets() {
        return Collections.unmodifiableMap(buckets);
    }
}
