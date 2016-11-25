package LoggerRateLimiter;

import java.util.HashMap;
import java.util.Map;

/**
 * 359. Logger Rate Limiter
 *
 * Design a logger system that receive stream of messages along with its timestamps,
 * each message should be printed if and only if it is not printed in the last 10 seconds.
 *
 * Given a message and a timestamp (in seconds granularity),
 * return true if the message should be printed in the given timestamp,
 * otherwise returns false.
 *
 * It is possible that several messages arrive roughly at the same time.
 */
public class LoggerRateLimiter {
    private Map<String, Integer> map;
    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        map = new HashMap<String, Integer>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        }
        else {
            if (timestamp - map.get(message) >= 10) {
                map.put(message, timestamp);
                return true;
            }
        }
        return false;
    }
}
