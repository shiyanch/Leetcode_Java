package NQueensII;

/**
 * 52. N-Queens II
 *
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations,
 * return the total number of distinct solutions.
 */
public class NQueensII {
    private int result = 0;
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        result = 0;
        backtrack(board, 0, 0);
        return result;
    }

    private void backtrack(int[][] board, int col, int count) {
        if (count == board.length) {
            // generate result here
            result++;
            return;
        }

        if (col > board.length-1) {
            return;
        }

        for (int i=0; i<board.length; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                backtrack(board, col+1, count+1);
                board[i][col] = 0;
            }
        }
    }

    private boolean isSafe(int[][] board, int row, int col) {
        for (int i=0; i<col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i=row, j=col; i>=0 && j>=0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i=row, j=col; i<board.length && j>=0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}
