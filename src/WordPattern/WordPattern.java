package WordPattern;

import java.util.HashMap;

/**
 * 290. Word Pattern
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match,
 * such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 *
 * Notes:
 * You may assume pattern contains only lowercase letters,
 * and str contains lowercase letters separated by a single space.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        String[] arrays = str.split(" ");

        if(pattern.length() != arrays.length)
            return false;

        for(int i=0;i<pattern.length();i++) {
            char c = pattern.charAt(i);
            if(map.containsKey(c)) {
                if(!map.get(c).equals(arrays[i]))
                    return false;
            }
            else {
                if(map.containsValue(arrays[i]))
                    return false;

                map.put(c, arrays[i]);
            }
        }

        return true;
    }
}
