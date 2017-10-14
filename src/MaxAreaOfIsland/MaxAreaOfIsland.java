package MaxAreaOfIsland;

import java.util.HashMap;
import java.util.Map;

/**
 * 695. Max Area of Island
 *
 * Given a non-empty 2D array grid of 0's and 1's,
 * an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] parents = new int[m*n];

        for (int i=0; i<m*n; i++) {
            if (grid[i/n][i%n] == 1) {
                parents[i] = i;
            } else {
                parents[i] = -1;
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                if (i>0 && grid[i-1][j] == 1) {
                    union(parents, (i-1)*n+j, i*n+j);
                }
                if (j>0 && grid[i][j-1] == 1) {
                    union(parents, i*n+(j-1), i*n+j);
                }
            }
        }

        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<m*n; i++) {
            if (parents[i] != -1) {
                int p = find(parents,i);
                map.put(p, map.getOrDefault(p, 0) + 1);
                max = Math.max(map.get(p), max);
            }
        }
        return max;
    }

    private int find(int[] nums, int id) {
        while (nums[id] != id) {
            nums[id] = nums[nums[id]];
            id = nums[id];
        }
        return id;
    }

    private void union(int[] nums, int i, int j) {
        int p_i = find(nums, i);
        int p_j = find(nums, j);
        nums[p_i] = p_j;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));
    }
}
