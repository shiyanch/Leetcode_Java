package NumberOfBoomerangs;

import java.util.HashMap;

/**
 * 447. Number of Boomerangs
 *
 * Given n points in the plane that are all pairwise distinct,
 * a "boomerang" is a tuple of points (i, j, k) such that
 * the distance between i and j equals the distance between i and k (the order of the tuple matters).
 *
 * Find the number of boomerangs.
 * You may assume that n will be at most 500 and
 * coordinates of points are all in the range [-10000, 10000] (inclusive).
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;

        for(int i=0;i<points.length;i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=0;j<points.length;j++) {
                int dis = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
                        + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                if(!map.containsKey(dis)) {
                    map.put(dis, 0);
                }
                count += map.get(dis)*2;
                map.put(dis, map.get(dis)+1);
            }
        }
        return count;
    }
}
