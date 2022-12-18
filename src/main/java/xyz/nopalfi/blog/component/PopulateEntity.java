package xyz.nopalfi.blog.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;
import xyz.nopalfi.blog.entity.Account;
import xyz.nopalfi.blog.entity.Post;
import xyz.nopalfi.blog.service.impl.AccountServiceImpl;
import xyz.nopalfi.blog.service.impl.PostServiceImpl;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class PopulateEntity implements CommandLineRunner {
    private final PostServiceImpl postService;

    private final AccountServiceImpl accountService;

    @Autowired
    public PopulateEntity(PostServiceImpl postService, AccountServiceImpl accountService) {
        this.postService = postService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        Account nopalfi = new Account();
        nopalfi.setFullName("nopalfi");
        nopalfi.setUsername("nopalfi");
        nopalfi.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("nopalfi"));
        nopalfi.setEmail("nopalfahriislami@yahoo.com");
        nopalfi.setRoles("USER");
        Account user = new Account();
        user.setFullName("user");
        user.setUsername("user");
        user.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("user"));
        user.setEmail("user@gmail.com");
        user.setRoles("USER");
        Post post1 = Post.builder()
                .title("Belajar Java")
                .content("""
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Faucibus ornare suspendisse sed nisi lacus sed. Augue neque gravida in fermentum et sollicitudin ac orci phasellus. Nisi quis eleifend quam adipiscing vitae. Scelerisque viverra mauris in aliquam. Pharetra massa massa ultricies mi quis hendrerit dolor. Netus et malesuada fames ac turpis. At risus viverra adipiscing at in tellus integer feugiat scelerisque. Cursus mattis molestie a iaculis at erat pellentesque adipiscing. Id eu nisl nunc mi ipsum faucibus. Accumsan tortor posuere ac ut. Morbi tristique senectus et netus et malesuada fames ac. Auctor urna nunc id cursus. Consectetur lorem donec massa sapien faucibus et molestie ac feugiat. Nec sagittis aliquam malesuada bibendum arcu. Tortor dignissim convallis aenean et tortor.

                        Nullam ac tortor vitae purus. Condimentum mattis pellentesque id nibh tortor id aliquet lectus. Tellus elementum sagittis vitae et leo duis ut diam. Nunc sed augue lacus viverra vitae congue eu consequat ac. In vitae turpis massa sed elementum. Nascetur ridiculus mus mauris vitae. Erat pellentesque adipiscing commodo elit at. Aliquam etiam erat velit scelerisque in dictum non consectetur a. Nisl nisi scelerisque eu ultrices vitae. In mollis nunc sed id semper. Facilisi etiam dignissim diam quis enim lobortis. Eget duis at tellus at. Pulvinar pellentesque habitant morbi tristique senectus et netus et. Enim nec dui nunc mattis enim. Tristique senectus et netus et malesuada fames ac turpis. Amet cursus sit amet dictum. Vitae proin sagittis nisl rhoncus mattis rhoncus urna neque. Laoreet suspendisse interdum consectetur libero.""")
                .createdAt(ZonedDateTime.of(2021, 6, 12, 8, 11, 0,0, ZoneId.of("UTC")).toEpochSecond())
                .account(nopalfi)
                .build();
        Post post2 = Post.builder()
                .title("Belajar Python")
                .content("""
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Faucibus ornare suspendisse sed nisi lacus sed. Augue neque gravida in fermentum et sollicitudin ac orci phasellus. Nisi quis eleifend quam adipiscing vitae. Scelerisque viverra mauris in aliquam. Pharetra massa massa ultricies mi quis hendrerit dolor. Netus et malesuada fames ac turpis. At risus viverra adipiscing at in tellus integer feugiat scelerisque. Cursus mattis molestie a iaculis at erat pellentesque adipiscing. Id eu nisl nunc mi ipsum faucibus. Accumsan tortor posuere ac ut. Morbi tristique senectus et netus et malesuada fames ac. Auctor urna nunc id cursus. Consectetur lorem donec massa sapien faucibus et molestie ac feugiat. Nec sagittis aliquam malesuada bibendum arcu. Tortor dignissim convallis aenean et tortor.

                        Nullam ac tortor vitae purus. Condimentum mattis pellentesque id nibh tortor id aliquet lectus. Tellus elementum sagittis vitae et leo duis ut diam. Nunc sed augue lacus viverra vitae congue eu consequat ac. In vitae turpis massa sed elementum. Nascetur ridiculus mus mauris vitae. Erat pellentesque adipiscing commodo elit at. Aliquam etiam erat velit scelerisque in dictum non consectetur a. Nisl nisi scelerisque eu ultrices vitae. In mollis nunc sed id semper. Facilisi etiam dignissim diam quis enim lobortis. Eget duis at tellus at. Pulvinar pellentesque habitant morbi tristique senectus et netus et. Enim nec dui nunc mattis enim. Tristique senectus et netus et malesuada fames ac turpis. Amet cursus sit amet dictum. Vitae proin sagittis nisl rhoncus mattis rhoncus urna neque. Laoreet suspendisse interdum consectetur libero.""")
                .createdAt(ZonedDateTime.of(2022, 9, 12, 8, 11, 0,0, ZoneId.of("UTC")).toEpochSecond())
                .account(nopalfi)
                .build();
        accountService.addAcount(nopalfi);
        accountService.addAcount(user);
        postService.addPost(post1);
        postService.addPost(post2);
    }
}
