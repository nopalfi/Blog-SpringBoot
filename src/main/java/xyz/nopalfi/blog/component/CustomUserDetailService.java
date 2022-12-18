package xyz.nopalfi.blog.component;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import xyz.nopalfi.blog.service.impl.AccountServiceImpl;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final WebApplicationContext context;
    private AccountServiceImpl accountService;

    @Autowired
    public CustomUserDetailService(WebApplicationContext context) {
        this.context = context;
    }

    @PostConstruct
    public void postConstruct() {
        accountService = context.getBean(AccountServiceImpl.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new CustomUserPrincipal(accountService.findByUsername(username));
    }
}
