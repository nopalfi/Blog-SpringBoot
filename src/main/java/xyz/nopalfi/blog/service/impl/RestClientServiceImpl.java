package xyz.nopalfi.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xyz.nopalfi.blog.entity.Post;
import xyz.nopalfi.blog.service.RestService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestClientServiceImpl implements RestService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${resources.rest.posts}")
    private String resources;

    @Override
    public List<Post> findAll() {
        return Arrays.stream(restTemplate.getForObject(resources, Post[].class)).collect(Collectors.toList());
    }

    @Override
    public Post findById(Long postId) {
        return restTemplate.getForObject(resources+"/"+postId, Post.class);
    }

    @Override
    public Post addPost(Post post) {
        return restTemplate.postForObject(resources, post, Post.class);
    }

    @Override
    public void deletePostById(Long postId) {

    }

    @Override
    public Post updatePost(Long postId, Post post) {
        return null;
    }

}
