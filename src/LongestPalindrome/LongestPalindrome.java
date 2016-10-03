package LongestPalindrome;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 409. Longest Palindrome
 *
 * Given a string which consists of lowercase or uppercase letters,
 * find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int res = 0;
        boolean hasEven = false;
        Iterator iterator = map.keySet().iterator();
        while(iterator.hasNext()) {
            int count = map.get(iterator.next());
            if(count%2==0)
                res += count;
            else {
                res += count-1;
                hasEven = true;
            }
        }

        if(hasEven)
            res++;

        return res;
    }
}
