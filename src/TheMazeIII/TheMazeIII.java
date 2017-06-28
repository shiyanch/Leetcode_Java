package TheMazeIII;

/**
 * 499. The Maze III
 *
 * Given the ball position, the hole position and the maze,
 * find out how the ball could drop into the hole by moving the shortest distance.
 *
 * The distance is defined by the number of empty spaces
 * traveled by the ball from the start position (excluded) to the hole (included).
 *
 * Output the moving directions by using 'u', 'd', 'l' and 'r'.
 * Since there could be several different shortest ways,
 * you should output the lexicographically smallest way.
 *
 * If the ball cannot reach the hole, output "impossible".
 */
public class TheMazeIII {
    private String direction = "dlru";
    private int[][] dirs = {{1,0}, {0,-1}, {0,1}, {-1,0}};
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if (maze == null || maze.length == 0) {
            return "";
        }
        String[][] dist = new String[maze.length][maze[0].length];
        int[][] distance = new int[maze.length][maze[0].length];
        dist[ball[0]][ball[1]] = "A";
        dfs(maze, hole, dist, distance, ball[0], ball[1]);
        return dist[hole[0]][hole[1]] == null? "impossible":dist[hole[0]][hole[1]].substring(1);
    }

    private void dfs(int[][] maze, int[] hole, String[][] dist, int[][] distance, int x, int y) {
        int m = maze.length;
        int n = maze[0].length;
        for (int d=0; d<dirs.length; d++) {
            String cur = dist[x][y];
            int i = x+dirs[d][0];
            int j = y+dirs[d][1];
            cur += direction.charAt(d);
            int curDis = distance[x][y]+1;
            while (isValid(m, n, i, j) && maze[i][j] == 0) {
                if (i == hole[0] && j == hole[1] && (dist[i][j] == null || curDis < distance[i][j] || (curDis == distance[i][j] && dist[i][j].compareTo(cur)>0))) {
                    dist[i][j] = cur;
                    distance[i][j] = curDis;
                    return;
                }

                i += dirs[d][0];
                j += dirs[d][1];
                curDis++;
            }
            i -= dirs[d][0];
            j -= dirs[d][1];
            curDis--;
            if (dist[i][j] != null && distance[i][j] <= curDis) {
                continue;
            }
            dist[i][j] = cur;
            distance[i][j] = curDis;
            dfs(maze, hole, dist, distance, i, j);
        }
    }
    private boolean isValid(int m, int n, int x, int y) {
        return x>=0 && x<m && y>=0 && y<n;
    }
}
