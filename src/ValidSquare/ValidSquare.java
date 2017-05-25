package ValidSquare;

/**
 * 593. Valid Square
 *
 * Given the coordinates of four points in 2D space,
 * return whether the four points could construct a square.
 *
 * The coordinate (x,y) of a point is represented by an integer array with two integers.
 */
public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return isSquare(p1, p2, p3, p4) || isSquare(p1, p3, p4, p2) || isSquare(p1, p3, p2, p4);

    }

    private boolean isSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] v1 = makeVector(p1, p2);
        int[] v2 = makeVector(p1, p4);
        int[] v3 = makeVector(p3, p2);
        int[] v4 = makeVector(p3, p4);
        int[] dia1 = makeVector(p1, p3);
        int[] dia2 = makeVector(p2, p4);
        return isVertical(v1, v2) && isVertical(v3, v4) && isVertical(dia1, dia2);
    }

    private int[] makeVector(int[] p1, int[] p2) {
        return new int[] {p1[0] - p2[0], p1[1] - p2[1]};
    }

    private boolean isVertical(int[] v1, int[] v2) {
        // Notice vector might be 0 (two points collapse)
        if ((v1[0] == v1[1] && v1[0] == 0) || (v2[0] == v2[1] && v2[0] == 0)) {
            return false;
        }
        return v1[0]*v2[0] + v1[1]*v2[1] == 0;
    }
}
