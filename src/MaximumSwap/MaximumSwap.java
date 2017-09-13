package MaximumSwap;

/**
 * 670. Maximum Swap
 *
 * Given a non-negative integer,
 * you could swap two digits at most once to get the maximum valued number.
 * Return the maximum valued number you could get.
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        int[] times = new int[10];
        int[] pos = new int[10];

        char[] n = String.valueOf(num).toCharArray();
        for (int i=0; i<n.length; i++) {
            times[n[i]-'0']++;
            pos[n[i]-'0'] = i;
        }

        int max = 9;
        for (int i=0; i<n.length; i++) {
            while (times[max] == 0) {
                max--;
            }

            if (n[i]-'0' != max) {
                int temp = n[i]-'0';
                n[i] = (char)(max+'0');
                n[pos[max]] = (char)(temp+'0');
                return Integer.parseInt(String.valueOf(n));
            } else {
                times[max]--;
            }
        }
        return num;
    }
}
