package SequenceReconstruction;

/**
 * 444. Sequence Reconstruction
 *
 * Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs.
 * The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104.
 *
 * Reconstruction means building a shortest common supersequence of the sequences in seqs
 * (i.e., a shortest sequence so that all sequences in seqs are subsequences of it).
 *
 * Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.
 */
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if (seqs == null || seqs.length == 0) {
            return false;
        }

        // org[i] -> org[i+1]是否在seqs中找到
        boolean[] pair = new boolean[org.length-1];
        // 还没找到的pair数
        int remainCount = org.length - 1;
        // 记录org中各字符在org出现的下标
        int[] index = new int[org.length+1];

        for (int i=0; i<org.length; i++) {
            index[org[i]] = i;
        }

        for (int[] seq : seqs) {
            for (int i=0; i<seq.length; i++) {
                // seqs中出现不在[1,n]的元素
                if (seq[i] < 0 || seq[i] > org.length) {
                    return false;
                }
                // seqs中出现顺序与org中相反的pair
                if (i > 0 && index[seq[i]] <= index[seq[i-1]]) {
                    return false;
                }
                // seqs中找到org中连续的一对pair
                if (i > 0 && index[seq[i]] == index[seq[i-1]]+1 && !pair[index[seq[i-1]]]) {
                    pair[index[seq[i-1]]] = true;
                    remainCount--;
                }
            }
        }

        return remainCount == 0;
    }
}
