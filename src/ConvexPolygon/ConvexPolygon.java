package ConvexPolygon;

import PacificAtlanticWaterFlow.PacificAtlanticWaterFlow;

import java.util.List;

/**
 * 469. Convex Polygon
 *
 * Given a list of points that form a polygon when joined sequentially,
 * find if this polygon is convex (Convex polygon definition).
 *
 * Note:
 * There are at least 3 and at most 10,000 points.
 * Coordinates are in the range -10,000 to 10,000.
 * You may assume the polygon formed by given points is always a simple polygon (Simple polygon definition).
 *
 * In other words, we ensure that exactly two edges intersect at each vertex,
 * and that edges otherwise don't intersect each other.
 */
public class ConvexPolygon {
    public boolean isConvex(List<List<Integer>> points) {
        boolean goNeg = false;
        boolean goPos = false;

        for (int i=0; i<points.size(); i++) {
            int crossProduct = countCrossProduct(points.get(i).get(0), points.get(i).get(1)
                    , points.get((i+1)%points.size()).get(0), points.get((i+1)%points.size()).get(1)
                    , points.get((i+2)%points.size()).get(0), points.get((i+2)%points.size()).get(1));
            if (crossProduct > 0) {
                goPos = true;
            }
            else if (crossProduct < 0){
                goNeg = true;
            }

            if (goNeg && goPos) {
                return false;
            }
        }

        return true;
    }

    private int countCrossProduct(int x1, int y1, int x2, int y2, int x3, int y3) {
        int line1_x = x1-x2;
        int line1_y = y1-y2;
        int line2_x = x3-x2;
        int line2_y = y3-y2;

        return line1_x * line2_y - line2_x * line1_y;

    }
}
