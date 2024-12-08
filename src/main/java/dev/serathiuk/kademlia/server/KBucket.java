package dev.serathiuk.kademlia.server;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class KBucket {

    private int bucketIndex;
    private LocalKademliaNode rootNode;
    private NodeRange nodeRange;
    private LinkedList<KademliaNode> nodes = new LinkedList<>();

    public KBucket(LocalKademliaNode rootNode, NodeRange nodeRange, int bucketIndex) {
        this.nodeRange = nodeRange;
        this.rootNode = rootNode;
        this.bucketIndex = bucketIndex;
    }

    public void addNode(KademliaNode node) {
        if (nodes.size() < rootNode.getConfig().maxBucketSize()) {
            nodes.add(node);
        } else {
            nodes.pollFirst();
            nodes.add(node);
        }
    }

    public Optional<KademliaNode> getNearestNode(String id) {
        var hash = rootNode.getConfig().hash(id);

        if(!nodeRange.containsHash(hash))
            return Optional.empty();

        return nodes.stream().min(KademliaNode.comparatorByDistance(hash));
    }

    public List<KademliaNode> getNodes() {
        return Collections.unmodifiableList(nodes);
    }

    public NodeRange getNodeRange() {
        return nodeRange;
    }

    public int getBucketIndex() {
        return bucketIndex;
    }

}
