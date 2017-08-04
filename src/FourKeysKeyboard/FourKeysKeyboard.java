package FourKeysKeyboard;

/**
 * 651. 4 Keys Keyboard
 *
 * Imagine you have a special keyboard with the following keys:
 * Key 1: (A): Prints one 'A' on screen.
 * Key 2: (Ctrl-A): Select the whole screen.
 * Key 3: (Ctrl-C): Copy selection to buffer.
 * Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.
 *
 * Now, you can only press the keyboard for N times (with the above four keys),
 * find out the maximum numbers of 'A' you can print on screen.
 */
public class FourKeysKeyboard {
    public int maxA(int N) {
        int[] dp = new int[N+1];
        for (int i=1; i<=N; i++) {
            dp[i] = i;
            if (i<7) {
                continue;
            }

            for (int j=1; j<i-2; j++) {
                // j for dp[j], 2 for select and copy, the rest i-j-2 for paste
                // So it should be dp[j] + (i-j-2)*dp[j] = dp[j] * (i-j-1)
                dp[i] = Math.max(dp[i], dp[j]*(i-j-1));
            }
        }
        return dp[N];
    }
}
