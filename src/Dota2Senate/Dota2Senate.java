package Dota2Senate;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 649. Dota2 Senate
 *
 * Given a string representing each senator's party belonging.
 * The character 'R' and 'D' represent the Radiant party and the Dire party respectively.
 * Then if there are n senators, the size of the given string will be n.
 *
 * The round-based procedure starts from the first senator to the last senator in the given order.
 * This procedure will last until the end of voting.
 * All the senators who have lost their rights will be skipped during the procedure.
 *
 * Suppose every senator is smart enough and will play the best strategy for his own party,
 * you need to predict which party will finally announce the victory and make the change in the Dota2 game.
 * The output should be Radiant or Dire.
 */
public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int index = 0;
        for (char c : senate.toCharArray()) {
            if (c == 'R') {
                radiant.offer(index++);
            } else {
                dire.offer(index++);
            }
        }
        int n = senate.length();
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();
            if (rIndex < dIndex) {
                radiant.offer(rIndex+n);
            } else {
                dire.offer(dIndex+n);
            }
        }
        if (!radiant.isEmpty()) {
            return "Radiant";
        } else {
            return "Dire";
        }
    }
}
