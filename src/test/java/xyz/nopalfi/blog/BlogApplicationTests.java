package xyz.nopalfi.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {

    @Value("${resources.rest.posts}")
    String resource;

    @Test
    void contextLoads() {
        System.out.println(resource);
    }

}
