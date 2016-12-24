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

        int[] map = new int[256];
        for (char c : s.toCharArray()) {
            map[c]++;
        }

        String[] records = new String[s.length()+1];

        for(int i = 0 ; i < 256; i++) { // join chars in the same bucket
            if(map[i] > 0)
                records[map[i]] = (records[map[i]] == null) ? "" + (char)i : (records[map[i]] + (char) i);
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
