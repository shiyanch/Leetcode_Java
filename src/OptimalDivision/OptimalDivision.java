package OptimalDivision;

/**
 * 553. Optimal Division
 *
 * Given a list of positive integers, the adjacent integers will perform the float division.
 * For example, [2,3,4] -> 2 / 3 / 4.
 *
 * However, you can add any number of parenthesis at any position to change the priority of operations.
 * You should find out how to add parenthesis to get the maximum result,
 * and return the corresponding expression in string format.
 *
 * Your expression should NOT contain redundant parenthesis.
 */
public class OptimalDivision {
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<nums.length; i++) {
            sb.append(nums[i]+"/");
        }
        sb.deleteCharAt(sb.length()-1);
        if (nums.length > 2) {
            sb.insert(sb.indexOf("/")+1, "(");
            sb.append(")");
        }
        return sb.toString();
    }
}
