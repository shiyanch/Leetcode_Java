package NumberOfDistinctIslands;

import java.util.HashSet;
import java.util.Set;

/**
 * 694. Number of Distinct Islands
 *
 * Given a non-empty 2D array grid of 0's and 1's,
 * an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 *
 * You may assume all four edges of the grid are surrounded by water.
 * Count the number of distinct islands.
 *
 * An island is considered to be the same as another if and only if
 * one island can be translated (and not rotated or reflected) to equal the other.
 */
public class NumberOfDistinctIslands {
    private int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    helper(grid, i, j, 0, 0, sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    private void helper(int[][] grid, int i, int j, int xPos, int yPos, StringBuilder sb) {
        grid[i][j] = 0;
        sb.append(xPos+""+yPos);
        for (int[] dir : dirs) {
            int x = i+dir[0];
            int y = j+dir[1];
            if (x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1) {
                helper(grid, x, y, xPos+dir[0], yPos+dir[1], sb);
            }
        }
    }
}
