package NQueens;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens
 *
 * The n-queens puzzle is the problem of placing n queens
 * on an n×n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 *
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 *
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> result = new ArrayList<>();
        backtrack(board, 0, 0, result);
        return result;
    }

    private void backtrack(int[][] board, int col, int count, List<List<String>> result) {
        if (count == board.length) {
            // generate result here
            List<String> list = new ArrayList<String>();
            for (int i=0; i<board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j=0; j<board[i].length; j++) {
                    sb.append((board[i][j] == 0)?".":"Q");
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }

        if (col > board.length-1) {
            return;
        }

        for (int i=0; i<board.length; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                backtrack(board, col+1, count+1, result);
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
