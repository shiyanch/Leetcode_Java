package PaintHouse;

/**
 * 256. Paint House
 *
 * There are a row of n houses,
 * each house can be painted with one of the three colors: red, blue or green.
 *
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color red;
 * costs[1][2] is the cost of painting house 1 with color green, and so on...
 *
 * Find the minimum cost to paint all houses.
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int last_red = costs[0][0];
        int last_blue = costs[0][1];
        int last_green = costs[0][2];

        for (int i = 1; i < costs.length; i++) {
            int curr_red = costs[i][0] + Math.min(last_blue, last_green);
            int curr_blue = costs[i][1] + Math.min(last_red, last_green);
            int curr_green = costs[i][2] + Math.min(last_blue, last_red);

            last_red = curr_red;
            last_blue = curr_blue;
            last_green = curr_green;
        }

        return Math.min(last_red, Math.min(last_blue, last_green));
    }
}
