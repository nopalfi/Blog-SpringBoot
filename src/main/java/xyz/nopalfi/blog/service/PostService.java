package xyz.nopalfi.blog.service;

import org.springframework.stereotype.Service;
import xyz.nopalfi.blog.entity.Post;
import xyz.nopalfi.blog.exception.ResourceNotFoundException;

import java.util.List;

public interface PostService {

    List<Post> getPosts();

    Post findById(Long id) throws ResourceNotFoundException;

    Post addPost(Post post);

    Post updatePost(Long id, Post post);

    void deletePost(Long id);

}
