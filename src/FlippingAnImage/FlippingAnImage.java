package FlippingAnImage;

/**
 * 832. Flipping an Image
 *
 * Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
 *
 * To flip an image horizontally means that each row of the image is reversed.
 *
 * For example, flipping [1,1,0] horizontally results in [0,1,1].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 *
 * For example, inverting [0,1,1] results in [1,0,0].
 */
public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int l = 0;
            int r = image[i].length - 1;

            while (l < r) {
                int temp = image[i][l];
                image[i][l] = 1 - image[i][r];
                image[i][r] = 1 - temp;
                l++;
                r--;
            }

            if (l == r) {
                image[i][l] = 1 - image[i][l];
            }
        }
        return image;
    }
}
