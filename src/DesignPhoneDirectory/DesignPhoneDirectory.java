package DesignPhoneDirectory;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 379. Design Phone Directory
 *
 * Design a Phone Directory which supports the following operations:
 *
 * get: Provide a number which is not assigned to anyone.
 * check: Check if a number is available or not.
 * release: Recycle or release a number.
 */
public class DesignPhoneDirectory {
    private final Queue<Integer> phoneNum = new LinkedList<>();
    private final Set<Integer> used = new HashSet<>();
    private final int maxNumbers;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public DesignPhoneDirectory(int maxNumbers) {
        this.maxNumbers = maxNumbers;
        for (int i=0; i<maxNumbers; i++) {
            phoneNum.offer(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        Integer phone = phoneNum.poll();
        if (phone == null) {
            return -1;
        }
        used.add(phone);
        return phone;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number >= this.maxNumbers || number < 0) {
            return false;
        }
        return !used.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (used.remove(number)) {
            phoneNum.offer(number);
        }
    }
}
