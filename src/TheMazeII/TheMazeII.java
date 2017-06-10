package TheMazeII;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 505. The Maze II
 *
 * There is a ball in a maze with empty spaces and walls.
 * The ball can go through empty spaces by rolling up, down, left or right,
 * but it won't stop rolling until hitting a wall.
 * When the ball stops, it could choose the next direction.
 *
 * Given the ball's start position, the destination and the maze,
 * find the shortest distance for the ball to stop at the destination.
 *
 * The distance is defined by the number of empty spaces
 * traveled by the ball from the start position (excluded) to the destination (included).
 * If the ball cannot stop at the destination, return -1.
 *
 * The maze is represented by a binary 2D array.
 * 1 means the wall and 0 means the empty space.
 * You may assume that the borders of the maze are all walls.
 * The start and destination coordinates are represented by row and column indexes.
 */
public class TheMazeII {
    class Point {
        int x, y, step;
        public Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return 0;
        }
        PriorityQueue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return p1.step-p2.step;
            }
        });
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int[][] length = new int[m][n];
        for (int i=0; i<m*n; i++) {
            length[i/n][i%n] = Integer.MAX_VALUE;
        }
        queue.offer(new Point(start[0], start[1], 0));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (length[point.x][point.y] <= point.step) {
                continue;
            }
            length[point.x][point.y] = point.step;
            for (int[] dir : dirs) {
                int x = point.x;
                int y = point.y;
                int step = point.step;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    step++;
                }
                x -= dir[0];
                y -= dir[1];
                step--;
                queue.offer(new Point(x, y, step));
            }
        }
        return length[destination[0]][destination[1]] == Integer.MAX_VALUE?-1:length[destination[0]][destination[1]];
    }
}
