package TheMaze;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 490. The Maze
 *
 * There is a ball in a maze with empty spaces and walls.
 * The ball can go through empty spaces by rolling up, down, left or right,
 * but it won't stop rolling until hitting a wall.
 * When the ball stops, it could choose the next direction.
 *
 * Given the ball's start position, the destination and the maze,
 * determine whether the ball could stop at the destination.
 *
 * The maze is represented by a binary 2D array.
 * 1 means the wall and 0 means the empty space.
 * You may assume that the borders of the maze are all walls.
 * The start and destination coordinates are represented by row and column indexes.
 */
public class TheMaze {
    class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        Queue<Point> queue = new LinkedList<>();
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        queue.offer(new Point(start[0], start[1]));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int[] dir : dirs) {
                int x = point.x;
                int y = point.y;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                if (visited[x][y]) {
                        continue;
                }
                visited[x][y] = true;
                if (x == destination[0] && y == destination[1]) {
                    return true;
                }
                queue.offer(new Point(x, y));
            }
        }
        return false;
    }
}
