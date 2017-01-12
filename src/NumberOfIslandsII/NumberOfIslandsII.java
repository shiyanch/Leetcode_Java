package NumberOfIslandsII;

import java.util.*;

/**
 * 305. Number of Islands II
 *
 * A 2d grid map of m rows and n columns is initially filled with water.
 * We may perform an addLand operation which turns the water at position (row, col) into a land.
 * Given a list of positions to operate, count the number of islands after each addLand operation.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        int count = 0;
        int[] union = new int[m*n];
        int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        Arrays.fill(union, -1);

        for (int[] position : positions) {
            int key = find(union, position[0]*n+position[1]);
            if (key == -1) {
                union[position[0]*n+position[1]] = position[0]*n+position[1];
                key = union[position[0]*n+position[1]];
                count++;
            }
            for (int[] dir : dirs) {
                if (!valid(position[0]+dir[0], position[1]+dir[1], m, n)) {
                    continue;
                }
                int neighbor = find(union, (position[0]+dir[0])*n+position[1]+dir[1]);
                if (neighbor != -1 && key != neighbor) {
                    count--;
                    union[neighbor] = key;
                }
            }
            result.add(count);
        }

        return result;
    }

    private boolean valid(int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    private int find(int[] union, int key) {
        if (union[key] == -1) {
            return -1;
        }
        while (union[key] != key) {
            union[key] = union[union[key]];
            key = union[key];
        }
        return key;
    }

    public static void main(String[] args) {
        int[][] positions = {{0,1},{1,2},{2,1},{1,0},{0,2},{0,0},{1,1}};
        System.out.println(new NumberOfIslandsII().numIslands2(3,3, positions));
    }
}
