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
        // 第一步只能从0跳1，因此stones[1]不为1则直接返回失败
        if (stones == null || stones.length == 0 || stones[1] != 1) {
            return false;
        }
        int[] moves = {-1, 0, 1};
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<Integer>());
        }
        map.get(1).add(1);
        for (int i=1; i<stones.length; i++) {
            for (int step : map.get(stones[i])) {
                for (int move : moves) {
                    int next = step + move + stones[i];
                    if (next != stones[i] && map.containsKey(next)) {
                        map.get(next).add(step+move);
                    }
                }
            }
        }
        return !map.get(stones[stones.length-1]).isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new FrogJump().canCross(new int[] {0,1}));
    }
}
