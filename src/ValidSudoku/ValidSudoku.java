package ValidSudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. Valid Sudoku
 * Determine if a Sudoku is valid
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();

        for(int i=0;i<9;i++) {
            set.clear();
            for(int j=0;j<9;j++) {
                if (board[i][j]=='.')
                    continue;
                if(set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
        }

        for(int i=0;i<9;i++) {
            set.clear();
            for(int j=0;j<9;j++) {
                if (board[j][i]=='.')
                    continue;
                if(set.contains(board[j][i]))
                    return false;
                set.add(board[j][i]);
            }
        }

        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                set.clear();
                for(int k=i;k<i+3;k++){
                    for(int l=j;l<j+3;l++){
                        if(board[k][l]=='.')continue;
                        char num=board[k][l];
                        if(set.contains(num))return false;
                        set.add(num);
                    }
                }
            }
        }


        return true;
    }
}
