package LineReflection;

import java.util.*;

/**
 * 356. Line Reflection
 *
 * Given n points on a 2D plane,
 * find if there is such a line parallel to y-axis that reflect the given points.
 */
public class LineReflection {
    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<>();
        for (int[] point : points) {
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
            set.add(point[0]+"a"+point[1]);
        }
        int sum = max+min;
        for (int[] point : points) {
            String str = (sum-point[0])+"a"+point[1];
            if (!set.contains(str)) {
                return false;
            }
        }
        return true;
    }
}
