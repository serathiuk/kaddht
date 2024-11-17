package dev.serathiuk.kademlia.server;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KBuckets {

    private final int maxBucketSize;
    private final KeyService keyService;
    private final Map<Integer, KBucket> buckets;

    public KBuckets(KeyService keyService, int maxBucketSize) {
        this.keyService = keyService;
        this.maxBucketSize = maxBucketSize;

        buckets = IntStream.range(0, keyService.getKeySize())
                .boxed()
                .collect(Collectors.toMap(k -> k, k -> new KBucket(keyService, null, maxBucketSize)));
    }

    public int getMaxBucketSize() {
        return maxBucketSize;
    }

    public KeyService getKeyService() {
        return keyService;
    }
}
