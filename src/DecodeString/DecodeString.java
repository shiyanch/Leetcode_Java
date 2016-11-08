package DecodeString;

import java.util.Stack;

/**
 * 394. Decode String
 *
 * Given an encoded string, return it's decoded string.
 *
 * The encoding rule is: k[encoded_string],
 * where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid;
 * No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits
 * and that digits are only for those repeat numbers, k.
 *
 * For example, there won't be input like 3a or 2[4].
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<String> symbols = new Stack<>();

        StringBuilder sb = new StringBuilder();

        boolean lastIsDigit = false;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                if(lastIsDigit) {
                    numbers.push(numbers.pop()*10 + (c-'0'));
                }
                else {
                    lastIsDigit = true;
                    numbers.push(c-'0');
                }
            }
            else {
                if(c == ']') {
                    StringBuilder tmp = new StringBuilder();
                    String curr = symbols.pop();
                    while (!curr.equals("[")) {
                        tmp.insert(0, curr);
                        curr = symbols.pop();
                    }

                    int times = numbers.pop();
                    String currStr = tmp.toString();
                    for(int j=1;j<times;j++) {
                        tmp.append(currStr);
                    }

                    symbols.push(tmp.toString());
                }
                else {
                    if(c == '[' && !lastIsDigit) {
                        numbers.push(1);
                    }
                    symbols.push(c+"");
                }

                lastIsDigit = false;
            }
        }

        StringBuilder tmp = new StringBuilder();
        while (!symbols.isEmpty()) {
            tmp.insert(0, symbols.pop());
        }

        sb.append(tmp);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a]"));
        System.out.println(new DecodeString().decodeString("3[a]2[b]"));
        System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
        System.out.println(new DecodeString().decodeString("3[a2[b]]"));
        System.out.println(new DecodeString().decodeString("3[a2[b3[v]c2[a]]]"));
        System.out.println(new DecodeString().decodeString("3[a]cbd"));
        System.out.println(new DecodeString().decodeString("3[a]c[b]d"));
    }
}
