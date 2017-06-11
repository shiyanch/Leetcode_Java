package DesignCompressedStringIterator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 604. Design Compressed String Iterator
 *
 * Design and implement a data structure for a compressed string iterator.
 * It should support the following operations: next and hasNext.
 *
 * The given compressed string will be in the form of each letter
 * followed by a positive integer representing the number of this letter
 * existing in the original uncompressed string.
 *
 * next() - if the original string still has uncompressed characters,
 * return the next letter; Otherwise return a white space.
 *
 * hasNext() - Judge whether there is any letter needs to be uncompressed.
 */
public class DesignCompressedStringIterator {
    Queue<int[]> queue = new LinkedList<>();
    public DesignCompressedStringIterator(String compressedString) {
        int i = 0;
        int n = compressedString.length();
        while (i < n) {
            int j = i+1;
            while (j < n && compressedString.charAt(j) - 'A' < 0) {
                j++;
            }
            queue.add(new int[] {
                    compressedString.charAt(i) - 'A',
                    Integer.parseInt(compressedString.substring(i+1, j))
            });
            i = j;
        }
    }

    public char next() {
        if (queue.isEmpty()) {
            return ' ';
        }
        int[] top = queue.peek();
        if (--top[1] == 0) {
            queue.poll();
        }
        return (char) ('A' + top[0]);
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
