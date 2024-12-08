package dev.serathiuk.kademlia.server;

import dev.serathiuk.kademlia.server.grpc.FindValueResponse;
import dev.serathiuk.kademlia.server.grpc.StoreResponse;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class LocalKademliaNode implements KademliaNode {

    private final Map<String, String> napValues = new HashMap<>();
    private final String id;
    private final KademliaConfig config;

    public LocalKademliaNode(KademliaConfig config) {
        this.id = config.generateId();
        this.config = config;
    }

    @Override
    public KademliaNode findNode(String id) {
        return null;
    }

    @Override
    public void ping(String id) {

    }

    @Override
    public StoreResponse store(String key, String value) {
        return null;
    }

    @Override
    public FindValueResponse findValue(String key) {
        return null;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getHost() {
        return config.host();
    }

    @Override
    public int getPort() {
        return config.port();
    }

    @Override
    public BigInteger getHash() {
        return config.hash(id);
    }

    public KademliaConfig getConfig() {
        return config;
    }
}
