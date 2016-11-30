package EvaluateReversePolishNotation;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /.
 *
 * Each operand may be an integer or another expression.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num1+num2);
            }
            else if (token.equals("-")) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num2-num1);
            }
            else if (token.equals("*")) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num1*num2);
            }
            else if (token.equals("/")) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num2/num1);
            }
            else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }
}
