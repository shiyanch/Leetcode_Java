package ValidPalindrome;

/**
 * 125. Valid Palindrome
 * Given a string, determine if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 *
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 * Note:
 * Have you consider that the string might be empty?
 * This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s){
        s = s.toLowerCase();
        int low = 0;
        int high = s.length()-1;

        while(low < high) {
            if(!isCharorNum(s.charAt(low))) {
                low++;
                continue;
            }

            if(!isCharorNum(s.charAt(high))) {
                high--;
                continue;
            }

            if(s.charAt(low) != s.charAt(high))
                return false;
            else {
                low++;
                high--;
            }
        }


        return true;
    }

    private boolean isCharorNum(char c) {
        return ((c>='a' && c<='z') || (c>='0' && c<= '9'));
    }
}
