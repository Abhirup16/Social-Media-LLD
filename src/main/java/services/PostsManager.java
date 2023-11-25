package services;

import entities.PostMetadata;
import entities.Posts;
import entities.User;

import javax.xml.crypto.Data;
import java.util.*;
import java.util.stream.Collectors;


public class PostsManager {
    Map<Long, Posts> postsMap = new HashMap<>();
    public void deletePost(Long postId) {
        Posts post = postsMap.get(postId);
         if(Objects.isNull(post)) {
             System.out.println("Could not find post");
             return;
         }
         post.setIsDeleted(true);
    }
    public void createPost(PostMetadata postMetadata, Long userId, Long postId) {
        Posts post = new Posts();
        post.setPostMetadata(postMetadata);
        post.setPostedBy(userId);
        post.setPostedOn((new Date()).getTime());
        post.setId(postId);
        postsMap.put(postId, post);
    }
    public List<Posts> getAllPosts(List<Long> userIds) {
        return postsMap.values().stream().filter(x -> userIds.contains(x.getPostedBy())).collect(Collectors.toList());
    }

}
