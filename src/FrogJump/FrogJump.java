package FrogJump;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 403. Frog Jump
 *
 * A frog is crossing a river.
 * The river is divided into x units and at each unit there may or may not exist a stone.
 * The frog can jump on a stone, but it must not jump into the water.
 *
 * Given a list of stones' positions (in units) in sorted ascending order,
 * determine if the frog is able to cross the river by landing on the last stone.
 *
 * Initially, the frog is on the first stone and assume the first jump must be 1 unit.
 * If the frog's last jump was k units,
 * then its next jump must be either k - 1, k, or k + 1 units.
 *
 * Note that the frog can only jump in the forward direction.
 *
 * Note:
 * The number of stones is ≥ 2 and is < 1,100.
 * Each stone's position will be a non-negative integer < 2^31.
 * The first stone's position is always 0.
 */
public class FrogJump {
    public boolean canCross(int[] stones) {
        if(stones == null || stones.length == 0 || stones[0] != 0)
            return false;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int s: stones)
            map.put(s, new HashSet<>());

        for(int s: stones) {
            Set<Integer> curSet = map.get(s);

            if(s == 0) {
                curSet.add(0);
                if(map.containsKey(1))
                    map.get(1).add(1);
            }

            for(int k : curSet) {
                int nextK = k-1;
                int nextStone = s + nextK;

                // previous k-1
                if(nextStone != s && map.containsKey(nextStone))
                    map.get(nextStone).add(nextK);

                // previous k
                nextStone++;
                nextK++;
                if(nextStone != s && map.containsKey(nextStone))
                    map.get(nextStone).add(nextK);

                // previous k+1
                nextStone++;
                nextK++;
                if(nextStone != s && map.containsKey(nextStone))
                    map.get(nextStone).add(nextK);
            }
        }
        return !map.get(stones[stones.length-1]).isEmpty();
    }
}
