package xyz.nopalfi.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.nopalfi.blog.entity.Post;
import xyz.nopalfi.blog.exception.ResourceNotFoundException;
import xyz.nopalfi.blog.repository.PostRepository;
import xyz.nopalfi.blog.service.PostService;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

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
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, Post post) {
        Post find = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "ID", id)
        );
        find.setTitle(post.getTitle());
        find.setContent(post.getContent());
        find.setModifiedAt(ZonedDateTime.now(ZoneId.of("UTC")).toEpochSecond());
        return postRepository.save(find);
    }

    @Override
    public void deletePost(Long id) {
        Post find = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "ID", id)
        );
        postRepository.delete(find);
    }
}
