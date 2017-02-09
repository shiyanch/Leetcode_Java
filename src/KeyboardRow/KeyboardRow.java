package KeyboardRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 500. Keyboard Row
 *
 * Given a List of words,
 * return the words that can be typed using letters of alphabet
 * on only one row's of American keyboard.
 *
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 *
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        String[] keys = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<keys.length; i++) {
            for (char c : keys[i].toCharArray()) {
                map.put(c, i);
            }
        }

        List<String> res = new ArrayList<String>();
        for (String w : words) {
            if (w.length() == 0) {
                continue;
            }
            String word = w.toLowerCase();
            int index = map.get(word.charAt(0));
            for (char c : word.toCharArray()) {
                if (map.get(c) != index) {
                    index = -1;
                    break;
                }
            }
            if (index != -1) {
                res.add(w);
            }
        }
        return res.toArray(new String[0]);
    }
}
