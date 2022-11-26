package xyz.nopalfi.blog.service;

import xyz.nopalfi.blog.entity.Account;

import java.util.List;

public interface AccountService {

    Account addAcount(Account account);
    void deleteAcount(Long accountId);
    Account updateAccount(Long accountId, Account account);
    List<Account> getAll();
    Account findById(Long accountId);
}
