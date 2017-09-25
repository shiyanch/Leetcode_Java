package ValidPalindromeII;

/**
 * 680. Valid Palindrome II
 *
 * Given a non-empty string s, you may delete at most one character.
 * Judge whether you can make it a palindrome.
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s.substring(l+1, r+1)) || isPalindrome(s.substring(l, r));
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
