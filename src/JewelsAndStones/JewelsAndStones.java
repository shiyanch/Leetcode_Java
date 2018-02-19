package JewelsAndStones;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. Jewels and Stones
 *
 * You're given strings J representing the types of stones that are jewels,
 * and S representing the stones you have.
 *
 * Each character in S is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct,
 * and all characters in J and S are letters.
 *
 * Letters are case sensitive,
 * so "a" is considered a different type of stone from "A".
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        for (char c : J.toCharArray()) {
            jewels.add(c);
        }

        int count = 0;
        for (char c : S.toCharArray()) {
            if (jewels.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
