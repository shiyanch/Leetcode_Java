package RemoveLetterToEqualizeFrequency;

/**
 * 2423. Remove Letter To Equalize Frequency
 *
 * You are given a 0-indexed string word, consisting of lowercase English letters.
 * You need to select one index and remove the letter at that index from word so that the frequency of every letter
 * present in word is equal.
 *
 * Return true if it is possible to remove one letter so that the frequency of all letters in word are equal,
 * and false otherwise.
 *
 * Note:
 *
 * The frequency of a letter x is the number of times it occurs in the string.
 * You must remove exactly one letter and cannot chose to do nothing.
 */

public class RemoveLetterToEqualizeFrequency {
    public boolean equalFrequency(String word) {
        int[] frequencies = new int[26];
        for (char c : word.toCharArray()) {
            frequencies[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (frequencies[i] != 0) {
                frequencies[i]--;
                if (allSame(frequencies)) {
                    return true;
                }
                frequencies[i]++;
            }
        }
        return false;
    }

    private static boolean allSame(int[] frequencies) {
        int value = 0;
        for (int fre : frequencies) {
            if (fre == 0) {
                continue;
            }
            if (value == 0) {
                value = fre;
            } else if (value != fre) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RemoveLetterToEqualizeFrequency sut = new RemoveLetterToEqualizeFrequency();

        System.out.println(sut.equalFrequency("abc"));
        System.out.println(sut.equalFrequency("abab"));
        System.out.println(sut.equalFrequency("aba"));
        System.out.println(sut.equalFrequency("bcc"));
        System.out.println(sut.equalFrequency("aa"));
        System.out.println(sut.equalFrequency("aaa"));
        System.out.println(sut.equalFrequency("aaab"));
    }
}
