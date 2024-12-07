package dev.serathiuk.kademlia.server;

import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;

public class KeyUtil {

    private KeyUtil() {}

    public static BigInteger hash(String key) {
        var hash = new BigInteger(1, key.getBytes(StandardCharsets.UTF_8));
        return hash.mod(KademliaNode.MAX_KEYS).add(BigInteger.valueOf(1));
    }

    public static String generateId(String host, int port) {
        return DigestUtils.sha256Hex(host +":"+ port);
    }

    public static Comparator<KademliaNode> getNodeComparator(KademliaNode node) {
        return (n1, n2) -> {
            var distance1 = n1.getDistance(node);
            var distance2 = n2.getDistance(node);
            return distance1.compareTo(distance2);
        };
    }

}
