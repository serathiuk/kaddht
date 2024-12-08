package dev.serathiuk.kademlia.server;

import dev.serathiuk.kademlia.server.grpc.FindValueResponse;
import dev.serathiuk.kademlia.server.grpc.StoreResponse;

import java.math.BigInteger;
import java.util.Comparator;

public interface KademliaNode {
    KademliaNode findNode(String id);
    void ping(String id);
    StoreResponse store(String key, String value);
    FindValueResponse findValue(String key);
    String getId();
    BigInteger getHash();
    String getHost();
    int getPort();


    default BigInteger getDistance(KademliaNode node) {
        return this.getHash().xor(node.getHash()).abs();
    }

    default BigInteger getDistance(BigInteger hash) {
        return this.getHash().xor(hash).abs();
    }

    static Comparator<KademliaNode> comparatorByDistance(KademliaNode node) {
        return comparatorByDistance(node.getHash());
    }

    static Comparator<KademliaNode> comparatorByDistance(BigInteger hash) {
        return (n1, n2) -> {
            var distance1 = n1.getDistance(hash);
            var distance2 = n2.getDistance(hash);
            return distance1.compareTo(distance2);
        };
    }
}
