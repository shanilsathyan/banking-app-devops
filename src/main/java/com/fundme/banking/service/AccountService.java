package com.fundme.banking.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fundme.banking.model.Account;
import com.fundme.banking.repository.AccountRepository;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account createAccount(Account account) {
        return repository.save(account);
    }

    public Account updateAccount(Long accountNo, Account account) {
        account.setAccountNo(accountNo);
        return repository.save(account);
    }

    public Optional<Account> getAccount(Long accountNo) {
        return repository.findById(accountNo);
    }

    public void deleteAccount(Long accountNo) {
        repository.deleteById(accountNo);
    }
}
