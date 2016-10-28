package SurroundedRegions;

/**
 * 130. Surrounded Regions
 *
 * Given a 2D board containing 'X' and 'O' (the letter O),
 * capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if(board == null || board.length == 0)
            return;

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<m;i++) {
            if(board[i][0] == 'O' && !visited[i][0]) {
                dfsVisit(board, visited, i, 0);
            }

            if(board[i][n-1] == 'O' && !visited[i][n-1]) {
                dfsVisit(board, visited, i, n-1);
            }
        }

        for(int j=0;j<n;j++) {
            if(board[0][j] == 'O' && !visited[0][j]) {
                dfsVisit(board, visited, 0, j);
            }

            if(board[m-1][j] == 'O' && !visited[m-1][j]) {
                dfsVisit(board, visited, m-1, j);
            }
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfsVisit(char[][] board, boolean visited[][], int i, int j) {
        if(visited[i][j])
            return;

        visited[i][j] = true;
        // 剪枝，防止递归层数太深
        if(i>1 && !visited[i-1][j] && board[i-1][j] == 'O') {
            dfsVisit(board, visited, i-1, j);
        }

        // 剪枝，防止递归层数太深
        if(i<board.length-2 && !visited[i+1][j] && board[i+1][j] == 'O') {
            dfsVisit(board, visited, i+1, j);
        }

        // 剪枝，防止递归层数太深
        if(j>1 && !visited[i][j-1] && board[i][j-1] == 'O') {
            dfsVisit(board, visited, i, j-1);
        }

        // 剪枝，防止递归层数太深
        if(j<board[0].length-2 && !visited[i][j+1] && board[i][j+1] == 'O') {
            dfsVisit(board, visited, i, j+1);
        }
    }
}
