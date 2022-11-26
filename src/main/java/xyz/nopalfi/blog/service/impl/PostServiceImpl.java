package xyz.nopalfi.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.nopalfi.blog.entity.Post;
import xyz.nopalfi.blog.exception.ResourceNotFoundException;
import xyz.nopalfi.blog.repository.PostRepository;
import xyz.nopalfi.blog.service.PostService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {

        return postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "ID", id)
        );
    }

    @Override
    public Post addPost(Post post) {
        LocalDateTime createdAt = LocalDateTime.now();
        post.setCreatedAt(createdAt);
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, Post post) {
        Post find = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "ID", id)
        );
        post.setTitle(find.getTitle());
        post.setContent(find.getContent());
        post.setCreatedAt(find.getCreatedAt());
        LocalDateTime localDateTime = LocalDateTime.now();
        post.setModifiedAt(localDateTime);
        return post;
    }

    @Override
    public void deletePost(Long id) {
        Post find = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "ID", id)
        );
        postRepository.delete(find);
    }
}
