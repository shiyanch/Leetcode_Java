package FirstUniqueCharcterInAString;

/**
 * 387. First Unique Character in a String
 *
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.
 *
 * Examples:
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 */
public class FirstUniqueCharcterInAString {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        for(Character c:s.toCharArray()) {
            map[c-'a']++;
        }

        for(int i=0;i<s.length();i++) {
            if(map[s.charAt(i)-'a'] == 1)
                return i;
        }

        return -1;
    }
}
