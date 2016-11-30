package RemoveKDigits;

import java.util.Stack;

/**
 * 402. Remove K Digits
 *
 * Given a non-negative integer num represented as a string,
 * remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && c < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            if (stack.isEmpty() && c == '0') {
                continue;
            }
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            while (k-- > 0) {
                stack.pop();
            }
            sb.insert(0, stack.pop());
        }

        return sb.length() == 0?"0":sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveKDigits().removeKdigits("10100", 1));
        System.out.println(new RemoveKDigits().removeKdigits("1432219", 3));
        System.out.println(new RemoveKDigits().removeKdigits("1432219", 2));
        System.out.println(new RemoveKDigits().removeKdigits("10", 4));
        System.out.println(new RemoveKDigits().removeKdigits("1", 4));
        System.out.println(new RemoveKDigits().removeKdigits("112", 1));
        System.out.println(new RemoveKDigits().removeKdigits("11112", 1));
        System.out.println(new RemoveKDigits().removeKdigits("11111", 1));
        System.out.println(new RemoveKDigits().removeKdigits("1323", 2));
        System.out.println(new RemoveKDigits().removeKdigits("1234567890", 9));
        System.out.println(new RemoveKDigits().removeKdigits("1234567809", 8));
    }
}
