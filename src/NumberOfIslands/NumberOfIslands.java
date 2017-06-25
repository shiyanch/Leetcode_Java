package NumberOfIslands;

import java.util.HashSet;
import java.util.Set;

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
    private int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    private class UnionFind {
        int[] father;
        int m,n;
        int count = 0;
        UnionFind(char[][] grid) {
            m = grid.length;
            n = grid[0].length;
            father = new int[m*n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        int id = i * n + j;
                        father[id] = id;
                        count++;
                    }
                }
            }
        }

        public void union(int node1, int node2) {
            int find1 = find(node1);
            int find2 = find(node2);
            if(find1 != find2) {
                father[find1] = find2;
                count--;
            }
        }
        public int find (int node) {
            if (father[node] == node) {
                return node;
            }
            father[node] = find(father[node]);
            return father[node];
        }
    }

    public int numIslands_uf(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)  {
            return 0;
        }
        UnionFind uf = new UnionFind(grid);
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    for (int[] d : dirs) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
                            int id1 = i*cols+j;
                            int id2 = x*cols+y;
                            uf.union(id1, id2);
                        }
                    }
                }
            }
        }
        return uf.count;
    }

    private boolean isValid(int m, int n, int i, int j) {
        return i>=0 && i<m && j>=0 && j<n;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println(new NumberOfIslands().numIslands_uf(grid));
    }

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
