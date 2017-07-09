package DesignLogStorageSystem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 635. Design Log Storage System
 *
 * You are given several logs that each log contains a unique id and timestamp.
 * Timestamp is a string that has the following format: Year:Month:Day:Hour:Minute:Second,
 * for example, 2017:01:01:23:59:59.
 * All domains are zero-padded decimal numbers.
 *
 * Design a log storage system to implement the following functions:
 * void Put(int id, string timestamp):
 *      Given a log's unique id and timestamp, store the log in your storage system.
 *
 * int[] Retrieve(String start, String end, String granularity):
 *      Return the id of logs whose timestamps are within the range from start to end.
 *      Start and end all have the same format as timestamp.
 *      However, granularity means the time level for consideration.
 *      For example, start = "2017:01:01:23:59:59", end = "2017:01:02:23:59:59", granularity = "Day",
 *      it means that we need to find the logs within the range from Jan. 1st 2017 to Jan. 2nd 2017.
 */
public class DesignLogStorageSystem {
    private final List<String[]> timestamps;
    private final List<String> units;
    private final int[] indices;
    public DesignLogStorageSystem() {
        timestamps = new LinkedList<>();
        units = Arrays.asList("Year", "Month", "Day", "Hour", "Minute", "Second");
        indices = new int[] {4,7,10,13,16,19};
    }

    public void put(int id, String timestamp) {
        timestamps.add(new String[] {Integer.toString(id), timestamp});
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> list = new LinkedList<>();
        int idx = indices[units.indexOf(gra)];
        for (String[] timestamp: timestamps) {
            if (timestamp[1].substring(0, idx).compareTo(s.substring(0, idx)) >= 0 &&
                    timestamp[1].substring(0, idx).compareTo(e.substring(0, idx)) <= 0) {
                list.add(Integer.parseInt(timestamp[0]));
            }
        }
        return list;
    }
}
