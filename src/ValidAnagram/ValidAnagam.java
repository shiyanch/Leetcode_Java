package ValidAnagram;

import java.util.Arrays;

/**
 * 242. Valid Anagram
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters?
 * How would you adapt your solution to such case?
 */

public class ValidAnagam {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();

        Arrays.sort(schar);
        Arrays.sort(tchar);

        for(int i=0; i<s.length(); i++)
            if(schar[i] != tchar[i])
                return false;

        return true;
    }
}
