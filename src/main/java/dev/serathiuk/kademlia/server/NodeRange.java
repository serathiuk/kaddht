package dev.serathiuk.kademlia.server;

import dev.serathiuk.kademlia.server.grpc.Node;

import java.math.BigInteger;

public record NodeRange(BigInteger hashStart, BigInteger hashEnd) {

    public boolean containsHash(BigInteger hash) {
        return hashStart.compareTo(hash) <= 0 && hashEnd.compareTo(hash) >= 0;
    }

    public static NodeRange generate(int index) {
        var start = BigInteger.valueOf(2).pow(index);
        var end = BigInteger.valueOf(2).pow(index+1).subtract(BigInteger.ONE);
        return new NodeRange(start, end);
    }

}

