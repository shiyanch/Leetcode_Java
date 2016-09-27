package QueueReconstructionByHeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 406. Queue Reconstruction by Height
 *
 * Suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of
 * people in front of this person who have a height greater than or equal to h.
 *
 * Write an algorithm to reconstruct the queue.
 * Note:
 * The number of people is less than 1,100.
 *
 * Example
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[0] - o1[0] != 0)
                    return o2[0] - o1[0];
                else
                    return o1[1] - o2[1];
            }
        });

        if(people.length <= 1)
           return people;

        for(int i=1;i<people.length;i++) {
            int count = 0;
            int j=0;
            while(j<i && count<people[i][1]) {
                count++;
                j++;
            }
            if(j<i) {
                int temp0 = people[i][0];
                int temp1 = people[i][1];
                for(int k=i;k>j;k--) {
                    people[k][0] = people[k - 1][0];
                    people[k][1] = people[k - 1][1];
                }
                people[j][0] = temp0;
                people[j][1] = temp1;
            }
        }
        return people;
    }


    // faster by using arraylist and priority queue
    public int[][] reconstructQueue2(int[][] people) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[0] - o1[0] != 0)
                    return o2[0] - o1[0];
                else
                    return o1[1] - o2[1];
            }
        });

        ArrayList<int[]> list = new ArrayList<>();
        for(int[] ppl : people)
            queue.offer(ppl);

        while(!queue.isEmpty()) {
            int[] pair = queue.poll();
            list.add(pair[1], pair);
        }

        int[][] res = new int[people.length][];
        for(int i=0;i<list.size();i++)
            res[i] = list.get(i);

        return res;
    }

}
