package TheSkylineProblem;

import java.util.*;

/**
 * 218. The Skyline Problem
 *
 * A city's skyline is the outer contour of the silhouette formed by all the buildings
 * in that city when viewed from a distance.
 *
 * Now suppose you are given the locations and height of all the buildings
 * as shown on a cityscape photo (Figure A),
 * write a program to output the skyline formed by these buildings collectively (Figure B).
 *
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi],
 * where Li and Ri are the x coordinates of the left and right edge of the ith building,
 * respectively, and Hi is its height.
 *
 * It is guaranteed that 0 ? Li, Ri ? INT_MAX, 0 < Hi ? INT_MAX, and Ri - Li > 0.
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 *
 * For instance, the dimensions of all buildings in Figure A are recorded as:
 * [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 *
 * The output is a list of "key points" (red dots in Figure B) in the format of
 * [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline.
 *
 * A key point is the left endpoint of a horizontal line segment.
 * Note that the last key point, where the rightmost building ends,
 * is merely used to mark the termination of the skyline, and always has zero height.
 *
 * Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 */
public class TheSkylineProblem {
    /**
     * 将int[] building拆成两个{坐标, 高度}的数组
     * 排序时如果遇到坐标相同：
     * 1. 两个升：高度更高的放前面，否则同一坐标会产生冗余
     * 2. 两个降：高度更低的放前面，否则同一坐标会产生冗余
     * 3. 一升一降：升的放前面，否则会产生冗余
     */
    public List<int[]> getSkyline(int[][] buildings) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
        List<int[]> height = new ArrayList<>();
        for (int[] building : buildings) {
            height.add(new int[] {building[0], -building[2]});
            height.add(new int[] {building[1], building[2]});
        }

        Collections.sort(height, (a,b) -> {
            return a[0] == b[0] ? a[1]-b[1] : a[0]-b[0];
        });

        List<int[]> res = new ArrayList<>();
        pq.offer(0);
        int prev = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if (prev != cur) {
                res.add(new int[] {h[0], cur});
                prev = cur;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] building = {0,2147483647,2147483647};
        int[][] buildings = {{0,2,3}, {2,5,3}};

        List<int[]> res = new TheSkylineProblem().getSkyline(buildings);
        for (int[] nums : res) {
            System.out.println(nums[0] + " " + nums[1]);
        }
    }
}
