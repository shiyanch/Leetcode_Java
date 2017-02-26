package TeemoAttacking;

/**
 * 495. Teemo Attacking
 *
 * In LLP world, there is a hero called Teemo
 * and his attacking can make his enemy Ashe be in poisoned condition.
 *
 * Now, given the Teemo's attacking ascending time series towards Ashe
 * and the poisoning time duration per Teemo's attacking,
 * you need to output the total time that Ashe is in poisoned condition.
 *
 * You may assume that Teemo attacks at the very beginning of a specific time point,
 * and makes Ashe be in poisoned condition immediately.
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }
        int result = 0;
        int lastAttack = timeSeries[0];
        for (int i=1; i<timeSeries.length; i++) {
            if (timeSeries[i] < lastAttack + duration) {
                result += timeSeries[i] - lastAttack;
            }
            else {
                result += duration;
            }
            lastAttack = timeSeries[i];
        }

        return result + duration;
    }
}
