package GuessNumberHigherOrLower;

/**
 * 374. Guess Number Higher or Lower
 *
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 *
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 */
public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        if(guess(n) == 0)
            return n;

        int low = 0, high = n;

        while(low < high) {
            int mid = (high-low)/2+low;
            if(guess(mid) == 0)
                return mid;
            if(guess(mid) < 0) {
                high = mid;
            }
            else low = mid;
        }

        return low;
    }

    private int guess(int num) {
        return -1;
    }
}
