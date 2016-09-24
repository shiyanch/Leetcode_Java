package DifferentWaysToAddParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * 241. Different Ways to Add Parentheses
 *
 * Given a string of numbers and operators,
 * return all possible results from computing all the different possible ways
 * to group numbers and operators.
 *
 * The valid operators are +, - and *.
 *
 * Input: "2*3-4*5"
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<input.length();i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                String a = input.substring(0,i);
                String b = input.substring(i+1);
                List<Integer> left = diffWaysToCompute(a);
                List<Integer> right = diffWaysToCompute(b);

                for(int x : left) {
                    for(int y : right) {
                        switch (c) {
                            case '+':
                                res.add(x+y);
                                break;
                            case '-':
                                res.add(x-y);
                                break;
                            case '*':
                                res.add(x*y);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        if(res.size() == 0)
            res.add(Integer.valueOf(input));
        return res;
    }
}
