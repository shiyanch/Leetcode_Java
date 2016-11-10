package SuperPow;

/**
 * 372. Super Pow
 *
 * Your task is to calculate a^b mod 1337 where a is a positive integer
 * and b is an extremely large positive integer given in the form of an array.
 *
 * Basic math knowlege:
 * (ab)%k=(a%k)(b%k)%k;
 * (abc)%k=(a%k)(b%k)(c%k)%k
 *
 * An example:
 * 23^1335%base
 * =(23^1330%base)(23^5%base)%base
 * =((23^133%base)^10)%base(23^5%base)%base
 * =function(function(23,133),10)*function(23,5)%base
 */
public class SuperPow {
    public int superPow(int a, int[] b) {
        return helper(a, b, b.length-1);
    }

    private int helper(int a, int[] b, int endIndex) {
        if(endIndex < 0) {
            return 1;
        }

        int lastDigit = b[endIndex];
        return powmod(helper(a, b, endIndex-1), 10) * powmod(a, lastDigit) % 1337;
    }

    private int powmod(int a, int k) {
        a %= 1337;
        int result = 1;
        for(int i=0;i<k;i++) {
            result = (result * a) % 1337;
        }

        return result;
    }
}
