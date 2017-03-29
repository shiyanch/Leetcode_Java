package PredictTheWinner;

/**
 * 486. Predict the Winner
 *
 * Given an array of scores that are non-negative integers.
 * Player 1 picks one of the numbers from either end of the array
 * followed by the player 2 and then player 1 and so on.
 *
 * Each time a player picks a number,
 * that number will not be available for the next player.
 *
 * This continues until all the scores have been chosen.
 * The player with the maximum score wins.
 *
 * Given an array of scores, predict whether player 1 is the winner.
 * You can assume each player plays to maximize his score.
 */
public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        return first(0, 0, nums, 0, nums.length-1);
    }

    private boolean first(int s1, int s2, int[] nums, int start, int end) {
        if (start > end){
            return s1 >= s2;
        }
        return !second(s1+nums[start], s2, nums, start+1, end) || !second(s1+nums[end], s2, nums, start, end-1);
    }

    private boolean second(int s1, int s2, int[] nums, int start, int end) {
        if (start > end){
            return s1 < s2;
        }
        return !first(s1, s2+nums[start], nums, start+1, end) || !first(s1, s2+nums[end], nums, start, end-1);
    }
}
