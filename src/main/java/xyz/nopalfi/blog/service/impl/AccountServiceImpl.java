package xyz.nopalfi.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.nopalfi.blog.entity.Account;
import xyz.nopalfi.blog.exception.ResourceNotFoundException;
import xyz.nopalfi.blog.repository.AccountRepository;
import xyz.nopalfi.blog.service.AccountService;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account addAcount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteAcount(Long accountId) {
        Account acc = accountRepository.findById(accountId).orElseThrow(
                () -> new ResourceNotFoundException("Account", "ID", accountId)
        );
        accountRepository.delete(acc);
    }

    @Override
    public Account updateAccount(Long accountId, Account account) {
        Account updateAcc = accountRepository.findById(accountId).orElseThrow(
                () -> new ResourceNotFoundException("Account", "ID", accountId)
        );
        account.setAccountId(accountId);
        account.setUsername(updateAcc.getUsername());
        account.setPassword(updateAcc.getPassword());
        account.setEmail(updateAcc.getEmail());
        account.setFullName(updateAcc.getFullName());
        account.setPosts(updateAcc.getPosts());
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Long accountId) {
        return accountRepository.findById(accountId).orElseThrow(
                () -> new ResourceNotFoundException("Account", "ID", accountId)
        );
    }

    @Override
    public Account findByUsername(String username) {
        Account account = accountRepository.findByUsername(username);
        return accountRepository.findByUsername(username);
    }
}
