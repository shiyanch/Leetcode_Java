package BasicCalculatorII;

import java.util.*;

/**
 * 227. Basic Calculator II
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers,
 * +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * You may assume that the given expression is always valid.
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;

        s = s.replaceAll(" ","");

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        for(int i=0;i<s.length();i++) {
            if(Character.isDigit(s.charAt(i)))
                num = 10*num+s.charAt(i)-'0';

            // i == s.length()-1 for the after-last run
            if(!Character.isDigit(s.charAt(i)) || i==s.length()-1) {
                if(sign == '+')
                    stack.push(num);
                else if(sign == '-')
                    stack.push(-num);
                else if(sign == '*')
                    stack.push(stack.pop()*num);
                else
                    stack.push(stack.pop()/num);

                sign = s.charAt(i);
                num = 0;
            }
        }

        int res = 0;
        for(int i : stack)
            res += i;

        return res;
    }


    public int calculate2(String s) {
        s = s.replaceAll(" ","");
        List<Character> operator = new LinkedList<>();
        List<Integer> number = new LinkedList<>();
        int num = 0;
        boolean priority = false;

        for(char c : s.toCharArray()) {
            if(Character.isDigit(c))
                num = 10*num+(int)(c-'0');
            else {
                number.add(num);
                num = 0;

                if(priority) {
                    char op = operator.remove(operator.size()-1);
                    int a = number.remove(number.size()-2);
                    int b = number.remove(number.size()-1);
                    if(op == '*')
                        number.add(a*b);
                    else
                        number.add(a/b);

                    priority = false;
                }

                if(c == '*' || c == '/')
                    priority = true;

                operator.add(c);
            }
        }
        number.add(num);
        if(priority) {
            char op = operator.remove(operator.size()-1);
            int a = number.remove(number.size()-2);
            int b = number.remove(number.size()-1);
            if(op == '*')
                number.add(a*b);
            else
                number.add(a/b);
        }

        while (!operator.isEmpty()) {
            char op = operator.remove(0);
            int a = number.remove(0);
            int b = number.remove(0);

            if(op == '+')
                number.add(0, a+b);
            else
                number.add(0, a-b);
//            else if(op == '*')
//                number.add(0, a*b);
//            else if(op == '/')
//                number.add(0, a/b);
        }

        return number.remove(number.size()-1);
    }

    public static void main(String[] args) {
//        System.out.println(new BasicCalculatorII().calculate("0"));
//        System.out.println(new BasicCalculatorII().calculate("1+2+3+4"));
//        System.out.println(new BasicCalculatorII().calculate("1+2+3-1-2-3"));
//        System.out.println(new BasicCalculatorII().calculate("1-3"));
        System.out.println(new BasicCalculatorII().calculate("1/33+1*9+1-3+3*3/3*2/9"));
    }
}
