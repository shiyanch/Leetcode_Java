package MeetingRooms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 252. Meeting Rooms
 *
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 *
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]], return false.
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

public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length < 2) {
            return true;
        }
        boolean cannot = false;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                return interval1.start - interval2.start;
            }
        });

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].start == intervals[i+1].start || intervals[i].end > intervals[i+1].start) {
                return false;
            }
        }
        return true;
    }
}
