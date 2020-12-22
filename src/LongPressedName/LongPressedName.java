package LongPressedName;

/**
 * 925. Long Pressed Name
 *
 * Your friend is typing his name into a keyboard. Sometimes, when typing a character c,
 * the key might get long pressed, and the character will be typed 1 or more times.
 *
 * You examine the typed characters of the keyboard.
 * Return True if it is possible that it was your friends name,
 * with some characters (possibly none) being long pressed.
 *
 * Example 1:
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 *
 * Example 2:
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 *
 * Example 3:
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 *
 * Example 4:
 * Input: name = "laiden", typed = "laidenx"
 * Output: false
 */
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) {
            return false;
        }

        int nameIndex = 0;
        int typedIndex = 0;

        while (nameIndex < name.length() && typedIndex < typed.length()) {
            if (name.charAt(nameIndex) != typed.charAt(typedIndex)) {
                return false;
            }

            int nameCount = 1;
            int typedCount = 1;

            while (nameIndex + 1 < name.length() && name.charAt(nameIndex) == name.charAt(nameIndex + 1)) {
                nameIndex++;
                nameCount++;
            }
            while (typedIndex + 1 < typed.length() && typed.charAt(typedIndex) == typed.charAt(typedIndex + 1)) {
                typedIndex++;
                typedCount++;
            }

            if (typedCount < nameCount) {
                return false;
            }

            nameIndex++;
            typedIndex++;
        }

        return nameIndex == name.length() && typedIndex == typed.length();
    }
}
