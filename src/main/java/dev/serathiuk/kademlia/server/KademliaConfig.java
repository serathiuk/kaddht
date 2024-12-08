package dev.serathiuk.kademlia.server;

import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public record KademliaConfig(String host, int port, int keySize, int maxBucketSize) {

    public BigInteger maxKeys() {
        return new BigInteger("2").pow(keySize).subtract(new BigInteger("1"));
    }

    public BigInteger hash(String key) {
        var hash = new BigInteger(1, key.getBytes(StandardCharsets.UTF_8));
        return hash.mod(maxKeys()).add(BigInteger.valueOf(1));
    }

    public String generateId() {
        return DigestUtils.sha256Hex(host +":"+ port);
    }



}
