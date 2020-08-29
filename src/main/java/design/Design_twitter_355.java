package design;

import javafx.util.Pair;

import java.util.*;

public class Design_twitter_355 {
    Map<Integer, Set<Integer>> users;
    List<Pair<Integer, Integer>> messages;

    /**
     * Initialize your data structure here.
     */
    public Design_twitter_355() {
        users = new HashMap<>();
        messages = new LinkedList<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {

        if (!users.containsKey(userId)) {
            HashSet<Integer> followed = new HashSet<>();
            followed.add(userId);
            users.put(userId, followed);
        }
        messages.add(new Pair<>(userId, tweetId));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if (users.containsKey(userId)) {
            if (messages.size() > 0) {
                ListIterator<Pair<Integer, Integer>> iterator = messages.listIterator(messages.size() - 1);
                int count = 0;
                Set<Integer> followed = users.get(userId);
                while (iterator.hasPrevious() && count < 10) {
                    Pair<Integer, Integer> message = iterator.previous();
                    if (followed.contains(message.getKey())) {
                        res.add(message.getValue());
                        count++;
                    }
                }
            }
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            HashSet<Integer> followed = new HashSet<>();
            followed.add(followerId);
            users.put(followerId, followed);
        }
        users.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId) && followeeId != followerId) {
            users.get(followerId).remove(followeeId);
        }
    }
}

class Test {
    public static void main(String[] args) {
        Design_twitter_355 twitter = new Design_twitter_355();

// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        twitter.getNewsFeed(1);

// 用户1关注了用户2.
        twitter.follow(1, 2);

// 用户2发送了一个新推文 (推文id = 6).
        twitter.postTweet(2, 6);

// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
// 推文id6应当在推文id5之前，因为它是在5之后发送的.
        twitter.getNewsFeed(1);

// 用户1取消关注了用户2.
        twitter.unfollow(1, 2);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
// 因为用户1已经不再关注用户2.
        twitter.getNewsFeed(1);

    }
}
