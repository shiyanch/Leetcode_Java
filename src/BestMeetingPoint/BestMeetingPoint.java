package BestMeetingPoint;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 296. Best Meeting Point
 *
 * A group of two or more people wants to meet and minimize the total travel distance.
 * You are given a 2D grid of values 0 or 1,
 * where each 1 marks the home of someone in the group.
 *
 * The distance is calculated using Manhattan Distance,
 * where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 */
public class BestMeetingPoint {
    // 取x、y的中位数，作为meeting point
    public int minTotalDistance(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x.add(j);
                    y.add(i);
                }
            }
        }
        Collections.sort(x);
        Collections.sort(y);
        int sum = 0;
        int xMedian = (x.size()%2==0)?(x.get(x.size()/2-1)+x.get(x.size()/2))/2:x.get(x.size()/2);
        int yMedian = (y.size()%2==0)?(y.get(y.size()/2-1)+y.get(y.size()/2))/2:y.get(y.size()/2);
        for (int i=0;i<x.size();i++) {
            sum += Math.abs(x.get(i) - xMedian);
            sum += Math.abs(y.get(i) - yMedian);
        }
        return sum;
    }
}
