package SuperUglyNumber;

import java.util.PriorityQueue;

/**
 * 313. Super Ugly Number
 *
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 * For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence
 * of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
 *
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] index = new int[len];
        int[] ugly = new int[n];
        ugly[0] = 1;

        for(int i=1;i<n;i++) {
            int min = Integer.MAX_VALUE;
            for(int j=0;j<len;j++) {
                min = Math.min(min, ugly[index[j]]*primes[j]);
            }

            ugly[i] = min;

            for(int j=0;j<len;j++)
                if(ugly[i] % primes[j] == 0)
                    index[j]++;
        }
        return ugly[n-1];
    }

    public int nthSuperUglyNumber2(int n, int[] primes) {
        if(n == 1)
            return 1;

        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1l);

        for(int i=1;i<n;i++) {
            long temp = pq.poll();

            while(!pq.isEmpty() && temp == pq.peek())
                pq.poll();


            for(int prime:primes) {
                pq.add(temp * prime);
            }
        }

        return pq.poll().intValue();
    }


}
