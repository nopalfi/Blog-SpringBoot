package xyz.nopalfi.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.nopalfi.blog.entity.Post;
import xyz.nopalfi.blog.service.impl.PostServiceImpl;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {

    @Autowired
    private PostServiceImpl postService;

    @GetMapping("")
    public ResponseEntity<List> getAllPosts() {
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Post> newPost(@RequestBody Post post) {
        return new ResponseEntity<>(postService.addPost(post), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        return new ResponseEntity<>(postService.findById(id), HttpStatus.FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        return new ResponseEntity<>(postService.updatePost(id, post), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.ACCEPTED);
    }
}
