package dev.serathiuk.kademlia.server;

import dev.serathiuk.kademlia.server.grpc.Node;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Optional;

public class KBucket {

    private int maxBucketSize;
    private NodeRange nodeRange;
    private KeyService keyService;
    private LinkedList<Node> nodes = new LinkedList<>();

    public KBucket(KeyService keyService, NodeRange nodeRange, int maxBucketSize) {
        this.maxBucketSize = maxBucketSize;
        this.keyService = keyService;
        this.nodeRange = nodeRange;
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
