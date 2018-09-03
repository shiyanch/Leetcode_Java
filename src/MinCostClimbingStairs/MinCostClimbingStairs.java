package MinCostClimbingStairs;

/**
 * 746. Min Cost Climbing Stairs
 *
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 *
 * Once you pay the cost, you can either climb one or two steps.
 *
 * You need to find minimum cost to reach the top of the floor,
 * and you can either start from the step with index 0, or the step with index 1.
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length < 2) {
            return 0;
        }
        int twoStepAway = cost[0];
        int oneStepAway = cost[1];
        for (int i=2; i<cost.length; i++) {
            int currentCost = Math.min(oneStepAway, twoStepAway) + cost[i];
            twoStepAway = oneStepAway;
            oneStepAway = currentCost;
        }

        return Math.min(oneStepAway, twoStepAway);
    }
}
