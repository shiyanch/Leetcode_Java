package NumberOfIslands;

/**
 * 200. Number of Islands
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and
 * is formed by connecting adjacent lands horizontally or vertically.
 *
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfsMarkMap(grid, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfsMarkMap(char[][] grid, boolean[][] visited, int i, int j) {
        if(visited[i][j])
            return;

        visited[i][j] = true;
        if(i>0 && grid[i-1][j] == '1' && !visited[i-1][j]) {
            dfsMarkMap(grid, visited, i-1, j);
        }

        if(i<grid.length-1 && grid[i+1][j] == '1' && !visited[i+1][j]) {
            dfsMarkMap(grid, visited, i+1, j);
        }

        if(j>0 && grid[i][j-1] == '1' && !visited[i][j-1]) {
            dfsMarkMap(grid, visited, i, j-1);
        }

        if(j<grid[0].length-1 && grid[i][j+1] == '1' && !visited[i][j+1]) {
            dfsMarkMap(grid, visited, i, j+1);
        }
    }
}
