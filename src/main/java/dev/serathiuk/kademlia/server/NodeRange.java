package dev.serathiuk.kademlia.server;

import java.math.BigInteger;

public record NodeRange(BigInteger hashStart, BigInteger hashEnd) {

    public boolean containsHash(BigInteger hash) {
        return hashStart.compareTo(hash) <= 0 && hashEnd.compareTo(hash) >= 0;
    }

}

