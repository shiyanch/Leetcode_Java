package SumOfSquareNumbers;

import java.util.HashSet;
import java.util.Set;

/**
 * 633. Sum of Square Numbers
 *
 * Given a non-negative integer c,
 * your task is to decide whether there're two integers a and b
 * such that a^2 + b^2 = c.
 */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<=Math.sqrt(c); i++) {
            int cur = i*i;
            set.add(cur);
            if (set.contains(c-cur)) {
                return true;
            }
        }
        return false;
    }
}
