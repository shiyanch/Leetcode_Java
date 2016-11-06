package FindRightInterval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 436. Find Right Interval
 *
 * Given a set of intervals, for each of the interval i,
 * check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i,
 * which can be called that j is on the "right" of i.
 *
 * For any interval i, you need to store the minimum interval j's index,
 * which means that the interval j has the minimum start point to build the "right" relationship for interval i.
 *
 * If the interval j doesn't exist, store -1 for the interval i.
 * Finally, you need output the stored value of each interval as an array.
 *
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * You may assume none of these intervals have the same start point.
 */
public class FindRightInterval {
    static class Interval {
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

    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<intervals.length;i++) {
            map.put(intervals[i].start, i);
        }

        Arrays.sort(intervals, new Comparator<FindRightInterval.Interval>() {
            @Override
            public int compare(FindRightInterval.Interval o1, FindRightInterval.Interval o2) {
                return o1.start - o2.start;
            }
        });

        for(int i=0;i<intervals.length;i++) {
            int target = intervals[i].end;
            int left = i+1;
            int right = intervals.length;
            while (left < right) {
                int mid = (right-left)/2+left;
                if(intervals[mid].start < target)
                    left = mid+1;
                else
                    right = mid;
            }

            result[map.get(intervals[i].start)] = (right == intervals.length)?-1:map.get(intervals[right].start);
        }
        return result;
    }
}
