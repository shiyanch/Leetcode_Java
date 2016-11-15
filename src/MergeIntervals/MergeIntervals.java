package MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
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

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) {
            return new ArrayList<Interval>();
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                else {
                    return o1.start - o2.start;
                }
            }
        });

        List<Interval> result = new ArrayList<Interval>();
        Interval prev = null;
        for(Interval interval : intervals) {
            if(prev == null || interval.start > prev.end) {
                result.add(interval);
                prev = interval;
            }
            else {
                prev.end = Math.max(prev.end, interval.end);
            }
        }

        return result;
    }
}
