package FeedStrategy;

import entities.Posts;
import lombok.Data;
import services.PostsManager;
import services.UserManager;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class RecentStrategy implements Strategy{
    UserManager userManager;
    PostsManager postManager;
    @Override
    public List<Long> fetchFeed(Long userId) {
        List<Long> follows = userManager.getFollows(userId);
        follows.add(userId);
        List<Posts> posts = postManager.getAllPosts(follows);
        Collections.sort(posts, Comparator.comparing(Posts::getPostedOn));
        return posts.stream().filter(x -> !x.getIsDeleted()).map(Posts::getId).collect(Collectors.toList());
    }

    public RecentStrategy(UserManager userManager, PostsManager postsManager) {
        this.userManager = userManager;
        this.postManager = postsManager;
    }
}
