package dev.serathiuk.kademlia.server;

import java.math.BigInteger;
import java.util.Comparator;

public interface KademliaNode {
    int KEY_SIZE = 256;
    int MAX_BUCKET_SIZE = 2;
    BigInteger MAX_KEYS = new BigInteger("2").pow(KEY_SIZE).subtract(new BigInteger("1"));

    String getId();
    String getHost();
    int getPort();

    default BigInteger getHash() {
        return KeyUtil.hash(this.getId());
    }

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
