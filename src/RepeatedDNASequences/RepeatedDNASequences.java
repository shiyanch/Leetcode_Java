package RepeatedDNASequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 187. Repeated DNA Sequences
 *
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA,
 * it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class RepeatedDNASequences {

    // Accepted but can't pass case "ACACACACACACTTT"
    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet<String>(), repeated = new HashSet<String>();
        for(int i=0;i+9<s.length();i++) {
            String ten = s.substring(i,i+10);
            if(!seen.add(ten))
                repeated.add(ten);
        }
        return new ArrayList<String>(repeated);
    }
}
