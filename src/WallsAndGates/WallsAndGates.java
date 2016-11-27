package WallsAndGates;

/**
 * 286. Walls and Gates
 *
 * You are given a m x n 2D grid initialized with these three possible values.
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room.
 *
 * We use the value 231 - 1 = 2147483647 to represent INF
 * as you may assume that the distance to a gate is less than 2147483647.
 *
 * Fill each empty room with the distance to its nearest gate.
 * If it is impossible to reach a gate, it should be filled with INF.
 */
public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        for (int i=0;i<rooms.length;i++) {
            for (int j=0;j<rooms[0].length;j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, 0, i, j);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int distance, int i, int j) {
        if (i < 0 || i >= rooms.length || j < 0 ||  j >= rooms[0].length || rooms[i][j] < distance) {
            return;
        }

        rooms[i][j] = distance;
        dfs(rooms, distance+1, i+1, j);
        dfs(rooms, distance+1, i-1, j);
        dfs(rooms, distance+1, i, j+1);
        dfs(rooms, distance+1, i, j-1);
    }
}
