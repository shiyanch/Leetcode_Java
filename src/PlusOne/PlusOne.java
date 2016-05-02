package PlusOne;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 66. Plus One
 * Given a non-negative number represented as an array of digits
 * plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
    // 对于大数该方法会溢出
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int base = (int)Math.pow(10,len-1);
        double num = 0;

        for(int i = 0;i<len;i++) {
            num += digits[i]*base;
            base /= 10;
        }

        num += 1;
        String temp = num+"";
        int[] result = new int[temp.length()];

        for(int i=0;i<temp.length();i++)
            result[i] = temp.charAt(i) - '0';

        return result;
    }

    public int[] plusOne2(int[] digits) {
        ArrayList<Integer> res = new ArrayList<>();
        int x = 0;
        for(int i=digits.length-1;i>=0;i--) {
            int temp = digits[i] + x;
            if(i == digits.length-1)
                temp += 1;

            res.add(0,temp%10);
            x = temp/10;
        }
        if(x != 0)
            res.add(0,x);
        int[] result = new int[res.size()];
        for(int i=0;i<res.size();i++)
            result[i] = res.get(i);

        return result;
    }
}
