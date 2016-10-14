package WordSearch;

/**
 * 79. Word Search
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == word.charAt(0) &&
                        dfs(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int start) {
        if(start == word.length())
            return true;

        if(i<0 || i==board.length || j<0 || j==board[0].length)
            return false;

        if(board[i][j] != word.charAt(start))
            return false;

        board[i][j] ^= 256;
        boolean exist = dfs(board, word, i-1, j, start+1) ||
                dfs(board, word, i+1, j, start+1) ||
                dfs(board, word, i, j-1, start+1) ||
                dfs(board, word, i, j+1, start+1);

        board[i][j] ^= 256;
        return exist;
    }

    public static void main(String[] args) {
        char[][] board = {{'a','b','c','e'},
                            {'s','f','e','s'},
                            {'a','d','e','e'}};


        System.out.println(new WordSearch().exist(board, "abceseeefs"));
//        System.out.println(new WordSearch().exist(board, "see"));
//        System.out.println(new WordSearch().exist(board, "abcb"));
    }
}
