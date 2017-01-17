package InsertInterval;


import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval
 *
 * Given a set of non-overlapping intervals,
 * insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 *
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {

    public static class Interval {
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

        public String toString() {
            return "["+start+" "+end+"]";
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i=0;
        while(i<intervals.size() && intervals.get(i).end < newInterval.start)
            i++;
        while(i<intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start),
                    Math.max(intervals.get(i).end, newInterval.end));
            intervals.remove(i);
        }

        intervals.add(i, newInterval);
        return intervals;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));

        Interval newInterval = new Interval(4,9);
        System.out.println(new InsertInterval().insert(intervals, newInterval));
    }
}
