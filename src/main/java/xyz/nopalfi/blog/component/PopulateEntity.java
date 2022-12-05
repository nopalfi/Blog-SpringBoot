package xyz.nopalfi.blog.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xyz.nopalfi.blog.entity.Account;
import xyz.nopalfi.blog.entity.Post;
import xyz.nopalfi.blog.service.impl.AccountServiceImpl;
import xyz.nopalfi.blog.service.impl.PostServiceImpl;

import java.time.LocalDateTime;

@Component
public class PopulateEntity implements CommandLineRunner {
    @Autowired
    private PostServiceImpl postService;
    @Autowired
    private AccountServiceImpl accountService;
    @Override
    public void run(String... args) throws Exception {
        Account nopalfi = new Account();
        nopalfi.setFullName("nopalfi");
        nopalfi.setUsername("nopalfi");
        nopalfi.setPassword("admin");
        nopalfi.setEmail("nopalfahriislami@yahoo.com");
        Account user = new Account();
        user.setFullName("user");
        user.setUsername("user");
        user.setPassword("user");
        user.setEmail("user@gmail.com");
        Post post1 = new Post();
        post1.setTitle("Belajar Java");
        post1.setContent("Belajar Bahasa Pemrograman dengan Java - Spring Boot");
        post1.setCreatedAt(LocalDateTime.now());
        post1.setAccount(nopalfi);
        Post post2 = new Post();
        post2.setTitle("Belajar Python");
        post2.setContent("Belajar Bahasa Pemrograman dengan Python - Flask");
        post2.setCreatedAt(LocalDateTime.now());
        post2.setAccount(nopalfi);
        accountService.addAcount(nopalfi);
        accountService.addAcount(user);
        postService.addPost(post1);
        postService.addPost(post2);
    }
}
