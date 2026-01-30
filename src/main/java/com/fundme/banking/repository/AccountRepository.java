package com.fundme.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fundme.banking.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
