package services;

import FeedStrategy.Strategy;
import entities.User;
import lombok.Data;

import java.util.*;

@Data
public class UserManager {
    Map<Long, User> userMap = new HashMap<>();
    Strategy strategy;

    public void handleFollow(Long followerId, Long followeeId) {
        User follower = userMap.get(followerId);
        User followee = userMap.get(followeeId);
        if(Objects.isNull(follower) || Objects.isNull(followee)) {
            System.out.println("user not found");
            return;
        }
        List<Long> currentFollowed = follower.getFollows();
        if(currentFollowed.contains(followeeId)) {
            System.out.println(String.format("You are already following %s", followee.getUserName()));
            return;
        }
        currentFollowed.add(followeeId);
        follower.setFollows(currentFollowed);
    }

    public void handleUnFollow(Long followerId, Long followeeId) {
        User follower = userMap.get(followerId);
        User followee = userMap.get(followeeId);
        if(Objects.isNull(follower) || Objects.isNull(followee)) {
            System.out.println("user not found");
            return;
        }
        List<Long> currentFollowed = follower.getFollows();
        if(!currentFollowed.contains(followeeId)) {
            System.out.println(String.format("You are not  following %s", followee.getUserName()));
            return;
        }
        currentFollowed.remove(followeeId);
        follower.setFollows(currentFollowed);
     }

    public void createUser(String name, Long id) {
        User user = new User();
        userMap.put(id, user);
    }

    public void deleteUser(Long id) {
        if(userMap.containsKey(id)) {
            User user = userMap.get(id);
            user.setIsActive(false);
            userMap.remove(id);
            return;
        }
        System.out.println("User not found");
    }
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public List<Long> getFeed(Long userId) {
       return strategy.fetchFeed(userId);
    }
    public List<Long> getFollows(Long userId) {
        return new ArrayList<>(userMap.get(userId).getFollows());
    }

}
