package xyz.nopalfi.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.nopalfi.blog.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);
}
