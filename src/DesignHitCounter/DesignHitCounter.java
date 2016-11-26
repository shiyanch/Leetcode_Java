package DesignHitCounter;

import java.util.ArrayList;
import java.util.List;

/**
 * 362. Design Hit Counter
 *
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 * Each function accepts a timestamp parameter (in seconds granularity)
 * and you may assume that calls are being made to the system in chronological order
 * (ie, the timestamp is monotonically increasing).
 *
 * You may assume that the earliest timestamp starts at 1.
 * It is possible that several hits arrive roughly at the same time.
 */
public class DesignHitCounter {
    private int[] times;
    private int[] hits;
    /** Initialize your data structure here. */
    public DesignHitCounter() {
        times = new int[300];
        hits = new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        hits[index] = (times[index] == timestamp)?hits[index]+1:1;
        times[index] = timestamp;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i=0; i<300; i++) {
            if (timestamp - times[i] < 300) {
                total += hits[i];
            }
        }
        return total;
    }
}
