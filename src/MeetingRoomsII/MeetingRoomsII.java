package MeetingRoomsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 253. Meeting Rooms II
 *
 * Given an array of meeting time intervals
 * consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 *
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 */

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length < 2) {
            return intervals.length;
        }
        boolean cannot = false;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                return interval1.start - interval2.start;
            }
        });

        ArrayList<Integer> rooms = new ArrayList<Integer>();
        rooms.add(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            boolean newRoom = true;
            for (int j=0; j<rooms.size(); j++) {
                if (intervals[i].start >= rooms.get(j)) {
                    rooms.set(j, intervals[i].end);
                    newRoom = false;
                    break;
                }
            }
            if (newRoom) {
                rooms.add(intervals[i].end);
            }
        }

        return rooms.size();
    }
}
