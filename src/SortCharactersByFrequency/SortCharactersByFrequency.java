package SortCharactersByFrequency;

import java.util.HashMap;
import java.util.Map;

/**
 * 451. Sort Characters By Frequency
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Input:
 * "tree"
 * Output:
 * "eert"
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        String[] records = new String[s.length()+1];
        for (Character c : map.keySet()) {
            records[map.get(c)] = (records[map.get(c)] == null?"":records[map.get(c)])+c;
        }

        for (int i=s.length(); i>=0; i--) {
            if (records[i] != null) {
                for (char c : records[i].toCharArray()) {
                    for (int j=0; j<i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SortCharactersByFrequency().frequencySort("tree"));
    }
}
