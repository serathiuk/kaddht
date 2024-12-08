package dev.serathiuk.kademlia.server;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class KademliaConfigTest {

    @Test
    void testGenerateId() {
        assertEquals("8b1fdc44bdaf9d6b7bdfa8b474864cbc57467393be4468704626ebab5e3ffea8", new KademliaConfig("localhost", 8080, 256, 2).generateId());
        assertEquals("c5645e79321f5c9a2b29404921eb8472ff6cdcc6e6acc581a590a8323a45f1fc", new KademliaConfig("domain.com.br", 421, 256, 2).generateId());
    }

    @Test
    void testHash() {
        var config = new KademliaConfig("localhost", 8080, 256, 2);
        assertEquals(new BigInteger("49573129395005122494700342960881214861864684927090378133736291175485292463004"), config.hash("8b1fdc44bdaf9d6b7bdfa8b474864cbc57467393be4468704626ebab5e3ffea8"));
        assertEquals(new BigInteger("91189493336029897776868682934628038690196563443883090736102954102217047907734"), config.hash("c5645e79321f5c9a2b29404921eb8472ff6cdcc6e6acc581a590a8323a45f1fc"));
    }

}