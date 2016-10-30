package RectangleArea;

/**
 * 223. Rectangle Area
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaA = (C-A)*(D-B);
        int areaB = (G-E)*(H-F);
        int intersection = 0;

        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);

        if(right > left && top > bottom)
            intersection = (right-left) * (top-bottom);

        return areaA+areaB-intersection;
    }

    public static void main(String[] args) {
        System.out.println(new RectangleArea().computeArea(-2,-2,2,2,-1,-1,1,1));
    }
}
