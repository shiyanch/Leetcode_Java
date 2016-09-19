package IsomorphicStrings;

import java.util.HashMap;

/**
 * 205. Isomorphic Strings
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 *
 * Test Cases:
 * "aa"
 * "ab"
 * "ab"
 * "aa"
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();

        for(int i=0;i<s.length();i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if(map.containsKey(a)) {
                if (map.get(a) != b)
                    return false;
            }
            else {
                if(a != b && map.containsValue(b))
                    return false;

                map.put(a, b);
            }
        }
        return true;
    }
}
