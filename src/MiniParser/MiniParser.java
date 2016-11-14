package MiniParser;

import java.util.List;
import java.util.Stack;

/**
 * 385. Mini Parser
 *
 * Given a nested list of integers represented as a string,
 * implement a parser to deserialize it.
 *
 * Each element is either an integer,
 * or a list -- whose elements may also be integers or other lists.
 *
 * Note: You may assume that the string is well-formed:
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 */
public class MiniParser {
    public NestedInteger deserialize(String s) {
        if(s == null || s.length() == 0) {
            return new NestedInteger();
        }

        Stack<NestedInteger> stack = new Stack<>();
        int sign = 1;

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == '[') {
                stack.push(new NestedInteger());
            }
            else if(c == ']' && stack.size()>1) {
                NestedInteger n = stack.pop();
                stack.peek().add(n);
            }
            else if(c == '-') {
                sign = -1;
            }
            else if(Character.isDigit(c)) {
                int num = c-'0';
                while (i+1<s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = num*10+s.charAt(i+1)-'0';
                    i++;
                }

                num = num*sign;
                if(!stack.isEmpty()) {
                    stack.peek().add(new NestedInteger(num));
                }
                else {
                    stack.push(new NestedInteger(num));
                }
                sign = 1;
            }
        }

        return stack.isEmpty()?new NestedInteger():stack.pop();
    }

}


class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger() {

    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {

    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return false;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return null;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {

    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {

    }
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return null;
    }
}
