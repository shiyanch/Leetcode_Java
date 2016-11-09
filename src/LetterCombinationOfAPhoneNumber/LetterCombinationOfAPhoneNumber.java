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
        Map<Integer, String> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0 || digits.contains("0") || digits.contains("1")) {
            return result;
        }

        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        for(char c : digits.toCharArray()) {
            List<String> newList = new ArrayList<>(result);
            result.clear();
            for (char nextChar : map.get(c - '0').toCharArray()) {
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
