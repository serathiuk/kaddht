package dev.serathiuk.kademlia.server;

import dev.serathiuk.kademlia.server.grpc.Node;

import java.math.BigInteger;
import java.util.*;

public class KBucket {

    private int maxBucketSize;
    private NodeRange nodeRange;
    private KeyService keyService;
    private int bucketIndex;
    private LinkedList<Node> nodes = new LinkedList<>();

    public KBucket(KeyService keyService, NodeRange nodeRange, int bucketIndex, int maxBucketSize) {
        this.maxBucketSize = maxBucketSize;
        this.keyService = keyService;
        this.nodeRange = nodeRange;
        this.bucketIndex = bucketIndex;
    }

    public void addNode(Node node) {
        if (nodes.size() < maxBucketSize) {
            nodes.add(node);
        } else {
            nodes.pollFirst();
            nodes.add(node);
        }
    }

    public Optional<Node> getNearestNode(String id) {
        var hash = keyService.hash(id);
        if(!nodeRange.containsHash(hash))
            return Optional.empty();

        return nodes.stream().min(getNodeComparator(hash));
    }

    private Comparator<Node> getNodeComparator(BigInteger nodeId) {
        return (n1, n2) -> {
            var distance1 = keyService.hash(n1.getId()).xor(nodeId);
            var distance2 = keyService.hash(n2.getId()).xor(nodeId);
            return distance1.compareTo(distance2);
        };
    }

    public List<Node> getNodes() {
        return Collections.unmodifiableList(nodes);
    }

    public int getBucketIndex() {
        return bucketIndex;
    }

    public NodeRange getNodeRange() {
        return nodeRange;
    }

    public int getMaxBucketSize() {
        return maxBucketSize;
    }

    public KeyService getKeyService() {
        return keyService;
    }
}
