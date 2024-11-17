package dev.serathiuk.kademlia.server;

import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class KeyService {

    private final int keySize;
    private final BigInteger maxKeys;

    public KeyService(int keySize) {
        this.keySize = keySize;
        this.maxKeys = new BigInteger("2").pow(keySize).subtract(new BigInteger("1"));
    }

    public BigInteger hash(String key) {
        var hash = new BigInteger(1, key.getBytes(StandardCharsets.UTF_8));
        return hash.mod(maxKeys).add(BigInteger.valueOf(1));
    }

    public String generateId(String host, int port) {
        return DigestUtils.sha256Hex(host +":"+ port);
    }

    public int getKeySize() {
        return keySize;
    }

    public BigInteger getMaxKeys() {
        return maxKeys;
    }
}
