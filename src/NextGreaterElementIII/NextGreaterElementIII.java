package NextGreaterElementIII;

/**
 * 556. Next Greater Element III
 *
 * Given a positive 32-bit integer n,
 * you need to find the smallest 32-bit integer
 * which has exactly the same digits existing in the integer n and is greater in value than n.
 *
 * If no such positive 32-bit integer exists, you need to return -1.
 */
public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        // 1. 从右向左，找到第一个下降元素，记下标为index
        if (n < 10) {
            return -1;
        }
        String s = String.valueOf(n);
        int index = -1;
        for (int i=s.length()-1; i>0; i--) {
            if (s.charAt(i) > s.charAt(i-1)) {
                index = i-1;
                break;
            }
        }
        if (index == -1) {
            return -1;
        }
        // 2. 在index右边部分，从右向左找到第一个大于index位置的下标i，交换index和i的值
        char[] str = s.toCharArray();
        for (int i=str.length-1; i>index; i--) {
            if (str[i] > str[index]) {
                char c = str[i];
                str[i] = str[index];
                str[index] = c;
                break;
            }
        }
        // 3. 此时index右边部分是逆序，将其reverse
        int left = index+1, right = str.length-1;
        while (left < right) {
            char c = str[left];
            str[left] = str[right];
            str[right] = c;
            left++;
            right--;
        }

        // 4. 将结果转为数组，注意可能会超出Integer的范围
        long res = Long.parseLong(new String(str));
        if (res > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) res;
    }
}
