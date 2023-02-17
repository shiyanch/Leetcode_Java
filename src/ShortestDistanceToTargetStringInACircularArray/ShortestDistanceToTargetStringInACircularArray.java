package ShortestDistanceToTargetStringInACircularArray;

import static java.lang.Integer.MAX_VALUE;

/**
 * 2515. Shortest Distance to Target String in a Circular Array
 *
 * You are given a 0-indexed circular string array words and a string target.
 * A circular array means that the array's end connects to the array's beginning.
 *
 * Formally, the next element of words[i] is words[(i + 1) % n] and the previous element of words[i] is
 * words[(i - 1 + n) % n], where n is the length of words.
 *
 * Starting from startIndex, you can move to either the next word or the previous word with 1 step at a time.
 * Return the shortest distance needed to reach the string target. If the string target does not exist in words,
 * return -1.
 */
public class ShortestDistanceToTargetStringInACircularArray {
    public int closetTarget(String[] words, String target, int startIndex) {
        int size = words.length;
        int globalShortestDistance = MAX_VALUE;
        for (int i = 0; i < size; i++) {
            String current = words[(i + startIndex) % size];
            if (current.equals(target)) {
                int shortestDistanceToCurrent = Math.min(i, size - i);
                globalShortestDistance = Math.min(globalShortestDistance, shortestDistanceToCurrent);
            }
        }
        return globalShortestDistance == MAX_VALUE ? -1 : globalShortestDistance;
    }

    public int closetTarget_faster(String[] words, String target, int startIndex) {
        int size = words.length;
        int globalShortestDistance = MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (words[i].equals(target)) {
                globalShortestDistance = Math.min(globalShortestDistance, calculateDistance(startIndex, i, size));
            }
        }
        return globalShortestDistance == MAX_VALUE ? -1 : globalShortestDistance;
    }

    private static int calculateDistance(int former, int later, int size) {
        int gap = Math.abs(later - former);
        return Math.min(gap, size - gap);
    }
}
