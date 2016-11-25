package GroupShiftedStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 249. Group Shifted Strings
 *
 * Given a string, we can "shift" each of its letter to its successive letter,
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 *
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets,
 * group all strings that belong to the same shifting sequence.
 *
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * A solution is:
 * [
 * ["abc","bcd","xyz"],
 * ["az","ba"],
 * ["acef"],
 * ["a","z"]
 * ]
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        if (strings == null || strings.length == 0) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            StringBuffer sb = new StringBuffer();
            if (string.length() > 0) {
                int dist = string.charAt(0) - 'a';
                sb.append('a');
                for (int i = 1; i < string.length(); i++) {
                    sb.append((string.charAt(i)-dist < 'a')?(char)(string.charAt(i)-dist+26):(char)(string.charAt(i)-dist));
                }
            }
            String str = sb.toString();
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<String>());
            }
            map.get(str).add(string);
        }

        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"az", "ba"};
        System.out.println(new GroupShiftedStrings().groupStrings(strings));
    }
}
