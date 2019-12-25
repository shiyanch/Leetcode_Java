package FibonacciNumber;

/**
 * 509. Fibonacci Number
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 */
public class FibonacciNumber {
    public int fib(int N) {
        int first = 0;
        int second = 1;

        if (N <= 1) {
            return N;
        }

        while((N--) - 2 >= 0) {
            int next = first + second;
            first = second;
            second = next;
        }
        return second;
    }
}
