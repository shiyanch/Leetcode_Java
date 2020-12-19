package ImplementRand10UsingRand7;

import java.util.Random;

/**
 * 470. Implement Rand10() Using Rand7()
 *
 * Given the API rand7() that generates a uniform random integer in the range [1, 7],
 * write a function rand10() that generates a uniform random integer in the range [1, 10].
 *
 * You can only call the API rand7(), and you shouldn't call any other API.
 * Please do not use a language's built-in random API.
 *
 * Each test case will have one internal argument n,
 * the number of times that your implemented function rand10() will be called while testing.
 * Note that this is not an argument passed to rand10().
 */
public class ImplementRand10UsingRand7 {
    public int rand10() {
        int column = rand7();
        int row = rand7();
        int val = (column) + (row - 1) * 7;
        if (val <= 40) {
            return (val - 1) % 10 + 1;
        } else {
            return rand10();
        }
    }

    private int rand7() {
        return new Random().nextInt(7) + 1;
    }
}
