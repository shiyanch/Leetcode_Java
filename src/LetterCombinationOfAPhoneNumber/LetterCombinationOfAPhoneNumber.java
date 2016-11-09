package LetterCombinationOfAPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 *
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 */
public class LetterCombinationOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        Map<Integer, char[]> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0 || digits.contains("0") || digits.contains("1")) {
            return result;
        }

        map.put(2, new char[] {'a', 'b', 'c'});
        map.put(3, new char[] {'d', 'e', 'f'});
        map.put(4, new char[] {'g', 'h', 'i'});
        map.put(5, new char[] {'j', 'k', 'l'});
        map.put(6, new char[] {'m', 'n', 'o'});
        map.put(7, new char[] {'p', 'q', 'r', 's'});
        map.put(8, new char[] {'t', 'u', 'v'});
        map.put(9, new char[] {'w', 'x', 'y', 'z'});

        for(char c : digits.toCharArray()) {
            List<String> newList = new ArrayList<>(result);
            result.clear();
            for (char nextChar : map.get(c - '0')) {
                if (newList.size() == 0) {
                    result.add(nextChar + "");
                } else {
                    for (String s : newList) {
                        s += nextChar;
                        result.add(s);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationOfAPhoneNumber().letterCombinations("2"));
    }

}
