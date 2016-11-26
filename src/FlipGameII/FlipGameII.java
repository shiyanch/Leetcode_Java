package FlipGameII;

import java.util.HashSet;
import java.util.Set;

/**
 * 294. Flip Game II
 *
 * You are playing the following Flip Game with your friend:
 * Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--".
 *
 * The game ends when a person can no longer make a move
 * and therefore the other person will be the winner.
 *
 * Write a function to determine if the starting player can guarantee a win.
 *
 * For example, given s = "++++", return true.
 * The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 */
public class FlipGameII {
    public boolean canWin(String s) {
        if(s == null || s.length() < 2) {
            return false;
        }
        return canWin(s, new HashSet<String>());
    }

    public boolean canWin(String s, Set<String> winSet) {
        if (winSet.contains(s)) {
            return true;
        }

        for (int i=0;i<s.length()-1;i++) {
            if (s.startsWith("++", i)) {
                String t = s.substring(0,i) + "--" + s.substring(i+2);
                if (!canWin(t, winSet)) {
                    winSet.add(s);
                    return true;
                }
            }
        }
        return false;
    }
}
