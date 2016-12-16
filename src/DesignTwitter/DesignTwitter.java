package DesignTwitter;

import java.util.*;

/**
 * 355. Design Twitter
 *
 * Design a simplified version of Twitter where users can post tweets,
 * follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed.
 *
 * Your design should support the following methods:
 * 1. postTweet(userId, tweetId): Compose a new tweet.
 * 2. getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed.
 *      Each item in the news feed must be posted by users who the user followed or by the user herself.
 *      Tweets must be ordered from most recent to least recent.
 * 3. follow(followerId, followeeId): Follower follows a followee.
 * 4. unfollow(followerId, followeeId): Follower unfollows a followee.
 */
public class DesignTwitter {

    private static class Tweet {
        private final Integer userId;
        private final Integer tweetId;
        public Tweet(Integer userId, Integer tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }

        public Integer getUserId() {
            return userId;
        }

        public Integer getTweetId() {
            return tweetId;
        }
    }

    private final ArrayList<Tweet> tweets;
    private final Map<Integer, Set<Integer>> followship;

    /** Initialize your data structure here. */
    public DesignTwitter() {
        this.tweets = new ArrayList<>();
        this.followship = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!followship.containsKey(userId)) {
            followship.put(userId, new HashSet<>());
            followship.get(userId).add(userId);
        }

        tweets.add(new Tweet(userId, tweetId));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        int count = 10;
        int index = tweets.size()-1;
        Set<Integer> followers = followship.get(userId);
        List<Integer> newsFeed = new ArrayList<>(10);
        while (followers != null && !tweets.isEmpty() && index >= 0 && count > 0) {
            if (followers.contains(tweets.get(index).getUserId())) {
                newsFeed.add(tweets.get(index).getTweetId());
                count--;
            }
            index--;
        }
        return newsFeed;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!followship.containsKey(followerId)) {
            followship.put(followerId, new HashSet<>());
            followship.get(followerId).add(followerId);
        }

        if (!followship.containsKey(followeeId)) {
            followship.put(followeeId, new HashSet<>());
            followship.get(followeeId).add(followeeId);
        }

        followship.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followship.containsKey(followerId) && followerId != followeeId) {
            followship.get(followerId).remove(followeeId);
        }
    }
}
