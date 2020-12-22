package ValidBoomerang;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1037. Valid Boomerang
 *
 * A boomerang is a set of 3 points that are all distinct and not in a straight line.
 *
 * Given a list of three points in the plane, return whether these points are a boomerang.
 *
 * Note:
 * points.length == 3
 * points[i].length == 2
 * 0 <= points[i][j] <= 100
 */
public class ValidBoomerang {
    public boolean isBoomerang(int[][] points) {
        if (identical(points) || alignHorizontal(points) || alignVertical(points)) {
            return false;
        }

        if (alignVertical(points[0], points[1]) || alignVertical(points[0], points[2])) {
            return true;
        }
        if (alignHorizontal(points[0], points[1]) || alignHorizontal(points[0], points[2])) {
            return true;
        }

        List<int[]> sortedPoints =
            Arrays.stream(points).sorted(Comparator.comparingInt(point -> point[0])).collect(Collectors.toList());
        int[] firstPt = sortedPoints.get(0);
        int[] secondPt = sortedPoints.get(1);
        int[] thirdPt = sortedPoints.get(2);
        return (firstPt[1] - secondPt[1]) * (secondPt[1] - thirdPt[1])
                != (firstPt[0] - secondPt[0]) * (secondPt[0] - thirdPt[0]);
    }

    private boolean identical(int[][] points) {
        return identical(points[0], points[1]) || identical(points[0], points[2]) || identical(points[1], points[2]);
    }
    private boolean identical(int[] point1, int[] point2) {
        return point1[0] == point2[0] && point1[1] == point2[1];
    }

    private boolean alignVertical(int[][] points) {
        return (points[0][0] == points[1][0]) && (points[0][0] == points[2][0]);
    }

    private boolean alignVertical(int[] point1, int[] point2) {
        return point1[0] == point2[0];
    }

    private boolean alignHorizontal(int[][] points) {
        return (points[0][1] == points[1][1]) && (points[0][1] == points[2][1]);
    }

    private boolean alignHorizontal(int[] point1, int[] point2) {
        return point1[1] == point2[1];
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2}, {0, 0}, {2, 1}};
        System.out.println(new ValidBoomerang().isBoomerang(input));
    }
}
