package xyz.nopalfi.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.nopalfi.blog.repository.AccountRepository;
import xyz.nopalfi.blog.service.impl.PostServiceImpl;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private AccountRepository repository;
    @Autowired
    private PostServiceImpl postService;
    @Value("${resources.rest.posts}")
    String resource;

    @Test
    void contextLoads() {
        System.out.println(resource);
    }

    @Test
    public void getPostsTest() {

    }

}
