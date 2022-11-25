package xyz.nopalfi.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xyz.nopalfi.blog.entity.Post;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestClientServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${resources.rest.posts}")
    private String resources;

    public List<Post> findAll() {
        return Arrays.stream(restTemplate.getForObject(resources, Post[].class)).collect(Collectors.toList());
    }

}
