package com.gesconge.gesconge.Services;



import com.gesconge.gesconge.Entities.Post;

import java.util.List;

public interface IPostService {
    List<Post> retrieveAllPosts();
    Post retrievePost(Long id);
    Post addPost(Post p);
    Post updatePost(Post P);
    void deletePost(Long id);
    public Post createPost( Long employeeId,Post post);
}
