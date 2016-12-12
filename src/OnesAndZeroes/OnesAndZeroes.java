package OnesAndZeroes;

/**
 * 474. Ones and Zeroes
 *
 * In the computer world,
 * use restricted resource you have to generate maximum benefit is what we always want to pursue.
 *
 * For now, suppose you are a dominator of m 0s and n 1s respectively.
 * On the other hand, there is an array with strings consisting of only 0s and 1s.
 *
 * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s.
 * Each 0 and 1 can be used at most once.
 *
 * Note:
 * The given numbers of 0s and 1s will both not exceed 100
 * The size of given string array won't exceed 600.
 */
public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for (String s : strs) {
            int[] pair = count(s);
            for (int i=m; i>=pair[0]; i--) {
                for (int j=n; j>=0; j--) {
                    if (i >= pair[0] && j >= pair[1]) {
                        dp[i][j] = Math.max(dp[i][j],1 + dp[i-pair[0]][j-pair[1]]);
                    }
                }
            }
        }

        return dp[m][n];
    }

    private int[] count(String s) {
        int[] pair = new int[2];
        for (int i=0;i<s.length();i++) {
            pair[s.charAt(i)-'0']++;
        }
        return pair;
    }

    public static void main(String[] args) {
        String[] strs =  {"10", "0001", "111001", "1", "0"};
        System.out.println(new OnesAndZeroes().findMaxForm(strs, 5,3));
    }
}
