package GameOfLife;

/**
 * 289. Game of Life
 * According to the Wikipedia's article:
 * "The Game of Life, also known simply as Life,
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * Given a board with m by n cells,
 * each cell has an initial state live (1) or dead (0).
 *
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
 * using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[][] res = new int[board.length][];
        for(int i=0;i<board.length;i++)
            res[i] = new int[board[i].length];

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                res[i][j] = liveOrDie(board, i, j);
            }
        }

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                board[i][j] = res[i][j];
            }
        }
    }

    private int liveOrDie(int[][] board, int i, int j) {
        int row = board.length;
        int col = board[0].length;

        int sum = 0;

        if(i>0) {
            if(j>0) {
                sum += board[i - 1][j - 1];
            }
            if(j<col-1) {
                sum += board[i - 1][j + 1];
            }
            sum+=board[i-1][j];
        }

        if(i<row-1) {
            if(j>0)
                sum += board[i+1][j-1];
            if(j<col-1)
                sum += board[i+1][j+1];
            sum += board[i+1][j];
        }

        if(j>0)
            sum += board[i][j-1];
        if(j<col-1)
            sum += board[i][j+1];

        if(board[i][j] == 0 && sum == 3)
            return 1;
        if(board[i][j] == 1 && (sum == 2 || sum == 3))
            return 1;

        return 0;
    }

    public static void main(String[] args) {
        int[][] hehe = new int[2][];
        hehe[0] = new int[]{1,1};
        hehe[1] = new int[] {1,0};

        new GameOfLife().gameOfLife(hehe);
    }
}
