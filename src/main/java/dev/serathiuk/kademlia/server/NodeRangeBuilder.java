package dev.serathiuk.kademlia.server;

import java.math.BigInteger;

public final class NodeRangeBuilder {
    private BigInteger start;
    private BigInteger end;

    private NodeRangeBuilder() {
    }

    public static NodeRangeBuilder aNodeRange() {
        return new NodeRangeBuilder();
    }

    public NodeRangeBuilder withStart(BigInteger start) {
        this.start = start;
        return this;
    }

    public NodeRangeBuilder withEnd(BigInteger end) {
        this.end = end;
        return this;
    }

    public NodeRange build() {
        return new NodeRange(start, end);
    }
}
