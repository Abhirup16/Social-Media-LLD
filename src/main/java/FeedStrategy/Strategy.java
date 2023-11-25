package FeedStrategy;

import services.PostsManager;
import services.UserManager;

import java.util.List;

public interface Strategy {
    public List<Long> fetchFeed(Long userId);
}
