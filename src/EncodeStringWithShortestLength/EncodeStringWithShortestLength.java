package EncodeStringWithShortestLength;

/**
 * 471. Encode String with Shortest Length
 *
 * Given a non-empty string,
 * encode the string such that its encoded length is the shortest.
 *
 * The encoding rule is: k[encoded_string],
 * where the encoded_string inside the square brackets is being repeated exactly k times.
 *
 * Note:
 * k will be a positive integer and encoded string will not be empty or have extra space.
 * You may assume that the input string contains only lowercase English letters.
 * The string's length is at most 160.
 *
 * If an encoding process does not make the string shorter, then do not encode it.
 * If there are several solutions, return any of them is fine.
 *
 * Input: "aaaaaaaaaa"
 * Output: "10[a]"
 *
 * Input: "aabcaabcd"
 * Output: "2[aabc]d"
 *
 * Input: "abbbabbbcabbbabbbc"
 * Output: "2[2[abbb]c]"
 */
public class EncodeStringWithShortestLength {
    public String encode(String s) {
        String[][] dp = new String[s.length()][s.length()];
        for (int l=0; l<s.length(); l++) {
            for (int i=0; i<s.length()-l; i++) {
                int j = i+l;
                String subStr = s.substring(i, j+1);
                dp[i][j] = subStr;
                if (j-i >= 4) {
                    for (int k=i; k<j; k++) {
                        String temp = dp[i][k] + dp[k+1][j];
                        if (temp.length() < dp[i][j].length()) {
                            dp[i][j] = temp;
                        }
                    }

                    for (int k=0; k<subStr.length(); k++) {
                        String repeat = subStr.substring(0, k+1);
                        if (repeat != null
                                && subStr.length()%repeat.length() == 0
                                && subStr.replaceAll(repeat,"").length() == 0) {

                            String ss = subStr.length()/repeat.length() + "["+dp[i][i+k]+"]";
                            if (ss.length() < dp[i][j].length()) {
                                dp[i][j] = ss;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
