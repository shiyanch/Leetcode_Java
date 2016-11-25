package UniqueWordAbbreviation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 288. Unique Word Abbreviation
 *
 * An abbreviation of a word follows the form <first letter><number><last letter>.
 * Assume you have a dictionary and given a word,
 * find whether its abbreviation is unique in the dictionary.
 *
 * A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 */
public class UniqueWordAbbreviation {
    HashMap<String, String> map = new HashMap<String, String>();

    public UniqueWordAbbreviation(String[] dictionary) {
        for(String str:dictionary){
            String key = getKey(str);
            // If there is more than one string belong to the same key
            // then the key will be invalid, we set the value to ""
            if(map.containsKey(key)){
                if(!map.get(key).equals(str)){
                    map.put(key, "");
                }
            }
            else{
                map.put(key, str);
            }
        }
    }

    public boolean isUnique(String word) {
        return !map.containsKey(getKey(word))||map.get(getKey(word)).equals(word);
    }

    String getKey(String str){
        if(str.length()<=2) return str;
        return str.charAt(0)+Integer.toString(str.length()-2)+str.charAt(str.length()-1);
    }
}
