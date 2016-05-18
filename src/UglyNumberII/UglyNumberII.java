package UglyNumberII;

import java.util.PriorityQueue;

/**
 * 264. Ugly Number II
 *
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 *
 * Note that 1 is typically treated as an ugly number.
 *
 * Hint:
 * 1. The naive approach is to call isUgly for every number until you reach the nth one.
 *    Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
 *
 * 2. An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
 *
 * 3. The key is how to maintain the order of the ugly numbers.
 *    Try a similar approach of merging from three sorted lists: L1, L2, and L3.
 *
 * 4. Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        if(n==1)
            return 1;

        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1l);

        for(int i=1;i<n;i++) {
            long temp = pq.poll();
            while(!pq.isEmpty() && temp == pq.peek())
                temp = pq.poll();

            pq.add(temp*2);
            pq.add(temp*3);
            pq.add(temp*5);
        }
        return pq.poll().intValue();
    }

    public int nthUglyNumber2(int n) {
        int index2=0, index3=0, index5=0;
        int factor2=2, factor3=3, factor5=5;
        int[] ugly = new int[n];
        ugly[0] = 1;

        for(int i=1;i<n;i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;

            if(min == factor2)
                factor2 = 2*ugly[++index2];
            if(min == factor3)
                factor3 = 3*ugly[++index3];
            if(min == factor5)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }
}
