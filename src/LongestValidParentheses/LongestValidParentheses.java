package LongestValidParentheses;

import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 *
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 *
 * For "(()", the longest valid parentheses substring is "()",
 * which has length = 2.
 *
 * Another example is ")()())",
 * where the longest valid parentheses substring is "()()",
 * which has length = 4.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<Integer>();
        int maxLen = 0;
        int curLen = 0;
        for(int i = 0; i < s.length();i++) {
            if(s.charAt(i) == '(') {
                st.push(curLen);
                curLen = 0;
            } else if (s.charAt(i) == ')') {
                if(st.isEmpty()) {
                    curLen = 0;
                } else {
                    curLen = curLen + st.pop() + 2;
                    if(curLen > maxLen) maxLen = curLen;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = ")";
        System.out.println(new LongestValidParentheses().longestValidParentheses(s));
    }
}
