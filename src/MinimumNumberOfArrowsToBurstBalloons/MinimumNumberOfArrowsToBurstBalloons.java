package MinimumNumberOfArrowsToBurstBalloons;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 *
 * There are a number of spherical balloons spread in two-dimensional space.
 * For each balloon, provided input is the start and end coordinates of the horizontal diameter.
 * Since it's horizontal, y-coordinates don't matter
 * and hence the x-coordinates of start and end of the diameter suffice.
 *
 * Start is always smaller than end. There will be at most 10^4 balloons.
 *
 * An arrow can be shot up exactly vertically from different points along the x-axis.
 * A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend.
 * There is no limit to the number of arrows that can be shot.
 * An arrow once shot keeps travelling up infinitely.
 * The problem is to find the minimum number of arrows that must be shot to burst all balloons.
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    // Use a integer "end" to track the end of each interval
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) {
            return 0;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        int end = points[0][1];
        int count = 1;
        for(int i=1;i<points.length;i++) {
            if(points[i][0] > end) {
                count++;
                end = points[i][1];
            }
            else {
                end = Math.min(end, points[i][1]);
            }
        }

        return count;
    }

    // Use Linked-List to record points
    // Slow and not concise
    public int findMinArrowShots2(int[][] points) {
        if(points == null) {
            return 0;
        }

        if(points.length <= 1) {
            return points.length;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        LinkedList<int[]> result = new LinkedList<>();
        result.add(points[0]);
        for(int i=1;i<points.length;i++) {
            int[] currPoint = points[i];
            int[] firstInList = result.peek();
            if(currPoint[0] <= firstInList[1]) {
                firstInList[0] = currPoint[0];
                firstInList[1] = Math.min(firstInList[1], currPoint[1]);
            }
            else {
                result.add(0, currPoint);
            }
        }

        return result.size();
    }

    public static void main(String[] args) {
        int[][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(points));
    }

}
