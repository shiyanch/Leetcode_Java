package LongestPalindromicSubstring;

/**
 * 5. Longest Palindromic Substring
 *
 * Given a string S, find the longest palindromic substring in S.
 *
 * You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String longestParlindrome = "";
        if(s == null || s.length() == 0)
            return longestParlindrome;
        if(s.length() == 1)
            return s;

        for(int i=0;i<s.length();i++) {
            int interval = 1;
            while (i-interval>=0 && i+interval<s.length()
                    && s.charAt(i-interval) == s.charAt(i+interval))
                interval++;
            if(2*interval-1 > longestParlindrome.length())
                longestParlindrome = s.substring(i-interval+1, i+interval);

            interval = 1;
            if(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                while (i - interval >= 0 && i+1 + interval < s.length()
                        && s.charAt(i-interval) == s.charAt(i+1+interval))
                    interval++;

                if(2*interval > longestParlindrome.length())
                    longestParlindrome = s.substring(i-interval+1, i+1+interval);
            }
        }

        return longestParlindrome;
    }

    public static void main(String[] args) {
        String str = new LongestPalindromicSubstring().longestPalindrome("acbcbcbabsbabcbabcba");
        System.out.println(str);
    }
}
