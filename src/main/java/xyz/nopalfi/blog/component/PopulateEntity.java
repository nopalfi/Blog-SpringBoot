package xyz.nopalfi.blog.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xyz.nopalfi.blog.entity.Post;
import xyz.nopalfi.blog.service.impl.PostServiceImpl;

import java.time.LocalDateTime;

@Component
public class PopulateEntity implements CommandLineRunner {
    @Autowired
    private PostServiceImpl postService;
    @Override
    public void run(String... args) throws Exception {
        Post post1 = new Post(1L, "Belajar Java", "Belajar Pemrograman dengan bahasa Java - Spring Boot", LocalDateTime.now(), null, 1L);
        Post post2 = new Post(2L, "Belajar Python", "Belajar Pemrograman dengan bahasa Python - Flask", LocalDateTime.now(), null, 1L);
        Post post3 = new Post(3L, "Belajar PHP", "Belajar Pemrograman dengan bahasa PHP - Laravel", LocalDateTime.now(), null, 1L);
        postService.addPost(post1);
        postService.addPost(post2);
        postService.addPost(post3);
    }
}
