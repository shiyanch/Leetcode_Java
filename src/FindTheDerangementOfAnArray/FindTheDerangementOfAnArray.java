package FindTheDerangementOfAnArray;

/**
 * 634. Find the Derangement of An Array
 *
 * In combinatorial mathematics,
 * a derangement is a permutation of the elements of a set,
 * such that no element appears in its original position.
 *
 * There's originally an array consisting of n integers from 1 to n in ascending order,
 * you need to find the number of derangement it can generate.
 *
 * Also, since the answer may be very large, you should return the output mod 10^9 + 7.
 */
public class FindTheDerangementOfAnArray {
    public int findDerangement(int n) {
        if (n<2) return 0;
        long f[]=new long[n+1];
        f[1]=0;f[2]=1;
        for (int i=3;i<=n;i++) f[i]=(f[i-1]+f[i-2])*(i-1)%1000000007;
        return (int)f[n];
    }
}
