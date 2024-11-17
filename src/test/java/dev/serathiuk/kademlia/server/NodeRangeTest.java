package dev.serathiuk.kademlia.server;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NodeRangeTest {

    @Test
    public void testNodeRangeContainsHash() {
        NodeRange nodeRange = new NodeRange(new BigInteger("1"), new BigInteger("3"));
        assertTrue(nodeRange.containsHash(new BigInteger("1")));
        assertTrue(nodeRange.containsHash(new BigInteger("2")));
        assertTrue(nodeRange.containsHash(new BigInteger("3")));
        assertFalse(nodeRange.containsHash(new BigInteger("4")));
    }

    @Test
    public void testNodeRangeBuilder() {
        NodeRange nodeRange = NodeRangeBuilder.aNodeRange()
                .withStart(new BigInteger("1"))
                .withEnd(new BigInteger("3"))
                .build();
        assertTrue(nodeRange.containsHash(new BigInteger("1")));
        assertTrue(nodeRange.containsHash(new BigInteger("2")));
        assertTrue(nodeRange.containsHash(new BigInteger("3")));
        assertFalse(nodeRange.containsHash(new BigInteger("4")));
    }

    @Test
    public void testNodeRangeLargeNumbers() {
        NodeRange nodeRange = new NodeRange(new BigInteger("9876543210"), new BigInteger("9999999999"));
        assertTrue(nodeRange.containsHash(new BigInteger("9876543210")));
        assertTrue(nodeRange.containsHash(new BigInteger("9999999999")));
        assertFalse(nodeRange.containsHash(new BigInteger("10000000000")));
    }

}