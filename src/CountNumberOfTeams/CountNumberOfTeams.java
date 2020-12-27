package CountNumberOfTeams;

/**
 * 1395. Count Number of Teams
 *
 * There are n soldiers standing in a line. Each soldier is assigned a unique rating value.
 *
 * You have to form a team of 3 soldiers amongst them under the following rules:
 *
 * 1. Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
 * 2. A team is valid if:
 * (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
 *
 * Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).
 */
public class CountNumberOfTeams {
    public int numTeams(int[] rating) {
        // ratingInfo[i][0]: number of soldiers by far with lower rating than soldier i.
        // ratingInfo[i][1]: number of soldiers by far with higher rating than soldier i.
        int[][] ratingInfo = new int[rating.length][2];
        int numberOfTeams = 0;
        for (int i = 1; i < rating.length; i++) {
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    ratingInfo[i][0]++;
                    numberOfTeams += ratingInfo[j][0];
                } else {
                    ratingInfo[i][1]++;
                    numberOfTeams += ratingInfo[j][1];
                }
            }
        }
        return numberOfTeams;
    }
}
