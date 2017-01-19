package PowXN;

/**
 * 50. Pow(x, n)
 * Implement pow(x, n).
 */
public class PowXN {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n<0){
            // 如果n是Integer.MIN_VALUE，直接-n会溢出
            return 1 / (x * myPow(x, -(n + 1)));
        }
        return n%2==0 ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}
