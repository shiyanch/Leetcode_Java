package UniqueBinarySearchTrees;

/**
 * 96. Unique Binary Search Trees
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * 1         3     3      2      1
 *  \       /     /      / \      \
 *   3     2     1      1   3      2
 *  /     /       \                 \
 * 2     1         2                 3
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<=n;i++) {
            for(int j=1;j<=i;j++)
                // j as root
                // unique BST of left-child : dp[j-1] (from 1 to j-1 : len = j-1-1+1 = j-1)
                // unique BST of right-child : dp[i-j] (from j+1 to i : len = i-(j+1)+1 = i=j)
                dp[i] += dp[i-j]*dp[j-1];
        }

        return dp[n];
    }
}
