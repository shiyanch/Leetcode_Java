package CompareVersionNumbers;

/**
 * 165. Compare Version Numbers
 *
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1,
 * if version1 < version2 return -1,
 * otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] num1 = version1.split("\\.");
        String[] num2 = version2.split("\\.");

        if(num1.length == 0 && num2.length == 0)
            return (Integer.valueOf(version1) < Integer.valueOf(version2)?-1:1);
        if(num1.length == 0 && num2.length != 0)
            num1[0] = version1;
        if(num2.length == 0 && num1.length != 0)
            num2[0] = version2;

        int i=0;
        while(i<num1.length && i<num2.length) {
            if(Integer.valueOf(num1[i]) > Integer.valueOf(num2[i]))
                return 1;
            if(Integer.valueOf(num1[i]) < Integer.valueOf(num2[i]))
                return -1;

            i++;
        }
        if(i == num1.length) {
            for(int j=i;j<num2.length;j++)
                if(Integer.valueOf(num2[j]) != 0)
                    return -1;
            return 0;
        }

        if(i == num2.length) {
            for(int j=i;j<num1.length;j++)
                if(Integer.valueOf(num1[j]) != 0)
                    return 1;
            return 0;
        }

        return 0;
    }

    public int compareVersion2(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");

        int len = Math.max(nums1.length, nums2.length);
        for(int i=0;i<len;i++) {
            Integer v1 = i<nums1.length?Integer.parseInt(nums1[i]):0;
            Integer v2 = i<nums2.length?Integer.parseInt(nums2[i]):0;
            int compare = v1.compareTo(v2);
            if(compare != 0)
                return compare;
        }

        return 0;
    }
}
