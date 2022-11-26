package xyz.nopalfi.blog.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    @NotNull
    private String title;
    @NotNull
    private String content;

    @NotNull
    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    @ManyToOne
    private Account account;

}
