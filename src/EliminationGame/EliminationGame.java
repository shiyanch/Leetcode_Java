package EliminationGame;

/**
 * 390. Elimination Game
 *
 * There is a list of sorted integers from 1 to n.
 * Starting from left to right, remove the first number
 * and every other number afterward until you reach the end of the list.
 *
 * Repeat the previous step again, but this time from right to left,
 * remove the right most number and every other number from the remaining numbers.
 *
 * We keep repeating the steps again,
 * alternating left to right and right to left, until a single number remains.
 *
 * Find the last number that remains starting with a list of length n.
 */
public class EliminationGame {

    // https://discuss.leetcode.com/topic/59293/java-easiest-solution-o-logn-with-explanation
    // 从左到右，head会被删除，因此head移动step
    // 从右到左，如果当前剩下来的是奇数个，则head会被删除，移动step步
    // 从右到左，如果当前剩下来的是偶数个，则head不会被删除，不移动
    public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 ==1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new EliminationGame().lastRemaining(7));
    }
}
