package ValidParentheses;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        int size = s.length();
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<size;i++) {
            char target = s.charAt(i);

            switch(target) {
                case '(':
                case '[':
                case '{':
                    stack.push(target);
                    break;

                case ')':
                case ']':
                case '}':
                    if(!stack.isEmpty()) {
                        char top = stack.pop();
                        if(
                                (target == '}' && top != '{') ||
                                        (target == ']' && top != '[') ||
                                        (target == ')' && top != '('))
                            return false;
                    }
                    else return false;
                    break;

                default:
                    return false;
            }
        }

        if(!stack.isEmpty())
            return false;
        else return true;
    }
}
