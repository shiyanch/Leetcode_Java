package WordSearchII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiyanch on 10/14/16.
 */
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for(String word:words) {
            if(exist(board, word))
                res.add(word);
        }

        return res;
    }

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
}
