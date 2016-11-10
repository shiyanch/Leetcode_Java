package GrayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. Gray Code
 *
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code,
 * print the sequence of gray code. A gray code sequence must begin with 0.
 *
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>((int)Math.pow(2, n));
        if(n == 0) {
            list.add(0);
            return list;
        }

        list.add(0);
        list.add(1);

        if(n == 1) {
            return list;
        }

        for(int i=1;i<n;i++) {
            int mask = 1 << i;
            for(int j = list.size()-1; j>=0;j--) {
                list.add(list.get(j) + mask);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(new GrayCode().grayCode(3).toString());
    }
}
