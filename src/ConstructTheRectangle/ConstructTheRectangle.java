package ConstructTheRectangle;

/**
 * 492. Construct the Rectangle
 *
 * For a web developer, it is very important to know how to design a web page's size.
 * So, given a specific rectangular web page’s area,
 * your job by now is to design a rectangular web page,
 * whose length L and width W satisfy the following requirements:
 *
 * 1. The area of the rectangular web page you designed must equal to the given target area.
 * 2. The width W should not be larger than the length L, which means L >= W.
 * 3. The difference between length L and width W should be as small as possible.
 * You need to output the length L and the width W of the web page you designed in sequence.
 */
public class ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
        while (w >= 1) {
            if (area % w == 0) {
                return new int[] {area/w, w};
            }
            w--;
        }
        return new int[] {area, 1};
    }
}
