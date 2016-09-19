package BullsAndCows;

/**
 * 299. Bulls and Cows
 *
 * You are playing the following Bulls and Cows game with your friend:
 * You write down a number and ask your friend to guess what the number is.
 * Each time your friend makes a guess, you provide a hint
 * that indicates how many digits in said guess match your secret number
 * exactly in both digit and position (called "bulls")
 * and how many digits match the secret number but locate in the wrong position (called "cows").
 *
 * Your friend will use successive guesses and hints to eventually derive the secret number.
 *
 * For example:
 *
 * Secret number:  "1807"
 * Friend's guess: "7810"
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int a = 0, b = 0;
        int[] record = new int[20];

        for(int i=0;i<secret.length();i++) {
            if(secret.charAt(i) == guess.charAt(i))
                a++;
            else {
                record[secret.charAt(i)-'0']++;
                record[10+guess.charAt(i)-'0']++;
            }
        }

        for(int i=0;i<10;i++) {
            if(record[i] == 0 || record[10+i] == 0)
                continue;
            else
                b += Math.min(record[i], record[i+10]);
        }

        return a+"A"+b+"B";
    }
}
