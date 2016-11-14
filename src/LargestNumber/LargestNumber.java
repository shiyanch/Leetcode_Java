package LargestNumber;

import java.util.*;

/**
 * 179. Largest Number
 *
 * Given a list of non negative integers,
 * arrange them such that they form the largest number.
 *
 * For example, given [3, 30, 34, 5, 9],
 * the largest formed number is 9534330.
 *
 * Note: The result may be very large,
 * so you need to return a string instead of an integer.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i=0;i<nums.length;i++) {
            strs[i] = nums[i]+"";
        }

        // Awesome
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String str1 = s1+s2;
                String str2 = s2+s1;
                return str2.compareTo(str1);
            }
        });

        if(strs[0].charAt(0)=='0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {128,12};
        System.out.println(new LargestNumber().largestNumber(nums));
    }
}
