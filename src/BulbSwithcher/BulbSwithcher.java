package BulbSwithcher;

/**
 * 319. Bulb Switcher
 * There are n bulbs that are initially off.
 * You first turn on all the bulbs.
 * Then, you turn off every second bulb.
 *
 * On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on).
 * For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb.
 * Find how many bulbs are on after n rounds.
 *
 * Example:
 * Given n = 3.
 *
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off].
 *
 * So you should return 1, because there is only one bulb is on.
 */
public class BulbSwithcher {
    public int bulbSwitch(int n) {
        if(n <= 0)
            return 0;

        int[] bulbs = new int[n+1];

        int step = 1;
        while(step <= n) {
            for(int i=step;i<n+1;i+=step) {
                bulbs[i] = (bulbs[i] == 0)?1:0;
            }
            step++;
        }

        int sum = 0;
        for(int status:bulbs) {
            sum += status;
        }

        return sum;
    }

    // explanation: https://leetcode.com/discuss/91371/share-my-o-1-solution-with-explanation
    public int bulbSwitch2(int n) {
        return (int)Math.sqrt(n);
    }
}
