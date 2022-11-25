package xyz.nopalfi.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.nopalfi.blog.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
