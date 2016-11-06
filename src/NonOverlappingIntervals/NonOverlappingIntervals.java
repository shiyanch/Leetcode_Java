package NonOverlappingIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. Non-overlapping Intervals
 *
 * Given a collection of intervals,
 * find the minimum number of intervals you need to remove
 * to make the rest of the intervals non-overlapping.
 *
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        ArrayList<Interval> res = new ArrayList<>();
        for(int i=0;i<intervals.length;i++) {
            if(res.isEmpty()) {
                res.add(intervals[i]);
            }
            else {
                Interval last = res.get(res.size()-1);
                if(intervals[i].start >= last.end) {
                    res.add(intervals[i]);
                }
                else {
                    if(intervals[i].end < last.end) {
                        res.remove(res.size()-1);
                        res.add(intervals[i]);
                    }
                }
            }
        }

        return intervals.length - res.size();
    }
}
