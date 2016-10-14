package BasicCalculator;

import java.util.Stack;

/**
 * 224. Basic Calculator
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * You may assume that the given expression is always valid.
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 */
public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int num = 0;
        int sign = 1;

        for(Character c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                num = 10 * num+(int)(c-'0');
            }
            else if(c == '+') {
                result += sign*num;
                num = 0;
                sign = 1;
            }
            else if(c == '-') {
                result += sign*num;
                num = 0;
                sign = -1;
            }
            else if(c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            }
            else if(c == ')') {
                result += sign*num;
                num = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }

        if(num != 0)
            result += sign*num;
        return result;
    }

    public static void main(String[]  args) {
        new BasicCalculator().calculate("1+2-3+3+(1-9)");
    }
}
