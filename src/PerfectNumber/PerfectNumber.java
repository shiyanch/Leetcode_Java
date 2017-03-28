package PerfectNumber;

/**
 * 507. Perfect Number
 * We define the Perfect Number is a positive integer
 * that is equal to the sum of all its positive divisors except itself.
 *
 * Now, given an integer n,
 * write a function that returns true when it is a perfect number and false when it is not.
 */
public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        int sum = 1;
        int i = 2;
        int bound = num/2;
        while(i < bound) {
            if(num % i == 0) {
                sum+=i;
                sum+=num/i;
                bound = num/i;
            }
            i++;
        }
        return sum==num;
    }
}
