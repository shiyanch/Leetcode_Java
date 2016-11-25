package RegularExpressionMatching;

/**
 * 10. Regular Expression Matching
 *
 * Implement regular expression matching with support for '.' and '*'.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) {
            return false;
        }

        if(s == null || p == null) {
            return false;
        }

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        // "", "a*b*c*" --> true
        // "a", "b*a" --> true (in line 51)
        for (int i=0; i<p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }

        /*
        1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
        2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
        3, If p.charAt(j) == '*':
        here are two sub conditions:
            1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
            2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                    dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
                 or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                 or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
         */

        for (int i=0; i<s.length(); i++) {
            for (int j=0; j<p.length(); j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if(p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }
                    else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }

        for (int i=0; i<s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                System.out.print(dp[i + 1][j + 1] + " ");
            }
            System.out.println();
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String s = "ab";
        String p = "a*b";
        System.out.println(new RegularExpressionMatching().isMatch(s, p));
    }
}
