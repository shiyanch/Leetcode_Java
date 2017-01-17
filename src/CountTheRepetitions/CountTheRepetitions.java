package CountTheRepetitions;

/**
 * Created by shiyanch on 1/17/17.
 */
public class CountTheRepetitions {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        int count1 = 0, count2 = 0, i = 0, j = 0;

        while (count1 < n1) {
            if (a1[i++] == a2[j]) {
                if (++j == a2.length) {
                    count2++;
                    j=0;
                }
            }
            if (i == a1.length) {
                i = 0;
                count1++;
            }
        }
        return count2 / n2;
    }

    public static void main(String[] args) {
        String s1 = "aahumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenazkycxf";
        int n1 = 1000000;
        String s2 = "aac";
        int n2 = 10;
        System.out.println(new CountTheRepetitions().getMaxRepetitions(s1, n1, s2, n2));
    }
}
