package Candy;

/**
 * 135. Candy
 *
 * There are N children standing in a line.
 * Each child is assigned a rating value.
 *
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
public class Candy {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];

        // from left to right
        for(int i=0;i<candies.length;i++)
            candies[i] = 1;

        // from right to left
        for(int i=1;i<ratings.length;i++) {
            if(ratings[i] > ratings[i-1])
                candies[i] = candies[i-1]+1;
        }

        for(int i=ratings.length-1;i>0;i--) {
            if(ratings[i] < ratings[i-1] && candies[i-1] < candies[i]+1)
                candies[i-1] = candies[i]+1;
        }

        int sum = 0;
        for(int i:candies)
            sum+=i;

        return sum;
    }

}
