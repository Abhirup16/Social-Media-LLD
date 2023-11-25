package com.trading.clone;

import FeedStrategy.RecentStrategy;
import entities.PostMetadata;
import services.PostsManager;
import services.UserManager;

import java.util.*;

public class SocialMedia {
	public static void main(String[] args) {
		UserManager userManager = new UserManager();
		PostsManager postsManager = new PostsManager();

		userManager.createUser("user1", 1L);
		userManager.createUser("user2", 2L);

		postsManager.createPost(new PostMetadata("user2post1"), 2L, 1L);
		postsManager.createPost(new PostMetadata("user2post2"), 2L, 2L);

		RecentStrategy recentStrategy = new RecentStrategy(userManager, postsManager);

		userManager.setStrategy(recentStrategy);

		userManager.handleFollow(1L, 3L);
		System.out.println(userManager.getFollows(1L));
		System.out.println(userManager.getFeed(1L));

		postsManager.deletePost(1L);
		System.out.print(userManager.getFeed(1L));

		userManager.handleUnFollow(1L, 2L);
		System.out.println(userManager.getFollows(1L));
		System.out.println(userManager.getFeed(1L));
	}
}
