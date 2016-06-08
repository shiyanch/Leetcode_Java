package CountPrimes;

/**
 * 204. Count Primes
 *
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrime {
    public int countPrimes(int n) {
        int count = 0;

        boolean[] isPrime = new boolean[n];

        for(int i=2;i<n;i++)
            isPrime[i] = true;

        for(int i=2; i*i < n; i++) {
            if(!isPrime[i])
                continue;
            else {
                for(int j=i*i; j<n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        for(int i=2;i<n;i++)
            if(isPrime[i])
                count++;

        return count;
    }
}
