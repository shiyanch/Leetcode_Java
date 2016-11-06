package ArranginCoins;

/**
 * 441. Arranging Coins
 *
 * You have a total of n coins that you want to form in a staircase shape,
 * where every k-th row must have exactly k coins.
 *
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 */
public class ArranginCoins {
    public int arrangeCoins(int n) {
        if(n <= 1)
            return n;

        long i = 1;
        while (i*i+i <= (long)2*n) {
            i++;
        }

        return (int)i-1;
    }
}
