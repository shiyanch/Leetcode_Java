package RotatedDigits;

/**
 * 788. Rotated Digits
 *
 * X is a good number if after rotating each digit individually by 180 degrees,
 * we get a valid number that is different from X.
 *
 * Each digit must be rotated - we cannot choose to leave it alone.
 *
 * A number is valid if each digit remains a digit after rotation.
 * 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other;
 * 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
 *
 * Now given a positive number N, how many numbers X from 1 to N are good?
 */
public class RotatedDigits {
    public int rotatedDigits(int N) {
        int count=0;
        for(int i=1; i<=N; i++){
            String num = String.valueOf(i);
            if (num.matches("[108]+")){
                continue;
            } else if (num.matches("[0182569]+")){
                count++;
            }
        }
        return count;
    }

    public int rotateDigits_dp(int N) {
        int[] dp = new int[N + 1];
        int count = 0;
        for(int i = 0; i <= N; i++){
            if(i < 10){
                if(i == 0 || i == 1 || i == 8) dp[i] = 1;
                else if(i == 2 || i == 5 || i == 6 || i == 9){
                    dp[i] = 2;
                    count++;
                }
            } else {
                int a = dp[i / 10], b = dp[i % 10];
                if(a == 1 && b == 1) dp[i] = 1;
                else if(a >= 1 && b >= 1){
                    dp[i] = 2;
                    count++;
                }
            }
        }
        return count;
    }
}
