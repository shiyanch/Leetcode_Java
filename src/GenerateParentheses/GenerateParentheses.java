package GenerateParentheses;


import java.util.LinkedList;
import java.util.List;

/**
 * 22. Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    // draw a call tree to help understand
    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str + "(", open + 1, close, max);
        if(close < open)
            backtrack(list, str + ")", open, close + 1, max);
    }
}
