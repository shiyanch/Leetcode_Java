package ReadNCharactersGivenRead4;

/**
 * 157. Read N Characters Given Read4
 *
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 *
 * The return value is the actual number of characters read.
 * For example, it returns 3 if there is only 3 characters left in the file.
 *
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 *
 * Note:
 * The read function will only be called once for each test case.
 */
public class ReadNCharactersGivenRead4 {
    public int read(char[] buf, int n) {
        boolean eof = false;
        int count = 0;
        char[] tmp = new char[4];
        while (!eof && count < n) {
            int curr = read4(tmp);
            eof = curr < 4;
            int border = Math.min(curr, n-count);
            for (int i=0; i < border; i++) {
                buf[count++] = tmp[i];
            }
        }
        return count;
    }

    /* The read4 API is defined in the parent class Reader4.*/
    private int read4(char[] buf) {
        // fake
        return 0;
    }

}
