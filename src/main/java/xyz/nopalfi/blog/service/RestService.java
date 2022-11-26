package xyz.nopalfi.blog.service;

import xyz.nopalfi.blog.entity.Post;

import java.util.List;

public interface RestService {
    List<Post> findAll();

    Post findById(Long postId);

    Post addPost(Post post);

    void deletePostById(Long postId);

    Post updatePost(Long postId, Post post);
}
