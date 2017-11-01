package OneBitAndTwoBitCharacters;

/**
 * 717. 1-bit and 2-bit Characters
 *
 * We have two special characters.
 * The first character can be represented by one bit 0.
 * The second character can be represented by two bits (10 or 11).
 *
 * Now given a string represented by several bits.
 * Return whether the last character must be a one-bit character or not.
 * The given string will always end with a zero.
 */
public class OneBitAndTwoBitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int ones = 0;
        for (int i=bits.length-2; i>=0; i--) {
            if (bits[i] == 1) {
                ones++;
            } else {
                break;
            }
        }

        return ones % 2 == 0;
    }
}
