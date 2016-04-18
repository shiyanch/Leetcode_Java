package HappyNumber;

import java.util.HashSet;

/**
 * 202. Happy Number
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process:
 * Starting with any positive integer
 * replace the number by the sum of the squares of its digits
 * and repeat the process until the number equals 1 (where it will stay)
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example: 19 is a happy number
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {
    private HashSet<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        return recursive_happy(n,n);
    }

    private boolean recursive_happy(int curNum, int original) {
        if(curNum == 1)
            return true;

        int res = 0;
        String newNum = Integer.toString(curNum);
        for(int i=0;i<newNum.length();i++) {
            int num = (int)(newNum.charAt(i) - '0');
            res += num*num;
        }

        if(set.contains(res))
            return false;
        else {
            set.add(res);
            return recursive_happy(res, original);
        }
    }

    public boolean isHappy2(int n) {
        if(n<=0)
            return false;

        while (n>=10) {
            n = cal(n);
        }

        return (n==1 || n == 7);
    }

    public boolean isHappy3(int n) {
        if(n<=0)
            return false;

        while(n != 1 || !set.contains(n)) {
            set.add(n);
            n = cal(n);
        }

        return (n==1);
    }

    private int cal(int n) {
        int sum = 0;

        String newNum = Integer.toString(n);
        for(int i=0;i<newNum.length();i++) {
            int num = (int)(newNum.charAt(i) - '0');
            sum += num*num;
        }

        return sum;
    }

    private int cal2(int n) {
        int sum = 0;

        while(n>0) {
            sum += (n%10) * (n%10);
            n /= 10;
        }

        return sum;
    }

}
