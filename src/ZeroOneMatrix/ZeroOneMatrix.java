package ZeroOneMatrix;

/**
 * 542. 01 Matrix
 *
 * Given a matrix consists of 0 and 1,
 * find the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 */
public class ZeroOneMatrix {
    class Position {
        int x, y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    private boolean isValid(List<List<Integer>> matrix, int x, int y) {
        return x>=0 && x<matrix.size() && y>=0 && y<matrix.get(x).size();
    }

    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        List<List<Integer>> list = new ArrayList<>(matrix.size());
        Queue<Position> queue = new LinkedList<>();
        for (int i=0; i<matrix.size(); i++) {
            for (int j=0; j<matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) == 0) {
                    queue.offer(new Position(i, j));
                }
                else {
                    matrix.get(i).set(j, -1);
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Position cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur.x+dir[0];
                    int y = cur.y+dir[1];
                    if (!isValid(matrix, x, y) || matrix.get(x).get(y) != -1) {
                        continue;
                    }
                    else {
                        matrix.get(x).set(y, matrix.get(cur.x).get(cur.y)+1);
                        queue.offer(new Position(x, y));
                    }
                }
            }
        }
        return matrix;
    }
}
