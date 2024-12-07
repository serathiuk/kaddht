package dev.serathiuk.kademlia.server;

public class LocalKademliaNode implements KademliaNode {

    private final String id;
    private final String host;
    private final int port;

    public LocalKademliaNode(String host, int port) {
        this.id = KeyUtil.generateId(host, port);
        this.host = host;
        this.port = port;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public int getPort() {
        return port;
    }

}
