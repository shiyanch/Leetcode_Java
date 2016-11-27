package DesignTicTacToe;

/**
 * 348. Design Tic-Tac-Toe
 *
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 *
 * You may assume the following rules:
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves is allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 */
public class DesignTicTacToe {
    private final int[] rows;
    private final int[] cols;
    private int diagonal;
    private int anti_diagonal;
    private final int n;

    /** Initialize your data structure here. */
    public DesignTicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal = anti_diagonal = 0;
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        rows[row] += (player==1)?1:-1;
        cols[col] += (player==1)?1:-1;
        if (row == col) {
            diagonal += (player==1)?1:-1;
        }
        if (row + col == n-1) {
            anti_diagonal += (player==1)?1:-1;
        }
        if (Math.abs(rows[row]) == n
                || Math.abs(cols[col]) == n
                || Math.abs(diagonal) == n
                || Math.abs(anti_diagonal) == n) {
            return player;
        }
        return 0;
    }

    public static void main(String[] args) {
        DesignTicTacToe game = new DesignTicTacToe(2);
        System.out.println(game.move(0,1,1));
        System.out.println(game.move(1,1,2));
        System.out.println(game.move(1,0,1));

    }
}
