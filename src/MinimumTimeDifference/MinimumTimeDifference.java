package MinimumTimeDifference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 539. Minimum Time Difference
 *
 * Given a list of 24-hour clock time points in "Hour:Minutes" format,
 * find the minimum minutes difference between any two time points in the list.
 *
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 * Note:
 * The number of time points in the given list is at least 2 and won't exceed 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 *
 * Case: ["12:00","00:01"] -> 719 rather than 721
 */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> list = new ArrayList<>(timePoints.size());
        for (String timePoint: timePoints) {
            String[] slot = timePoint.split(":");
            int time = Integer.valueOf(slot[0])*60 + Integer.valueOf(slot[1]);
            list.add(time);
        }

        Collections.sort(list);

        long min = Long.MAX_VALUE;
        for (int i=1; i<list.size(); i++) {
            int diff = list.get(i) - list.get(i-1);
            min = Math.min(min, diff);
        }

        min = Math.min(min, 1440+list.get(0)-list.get(list.size()-1));
        return (int)min;
    }
}
