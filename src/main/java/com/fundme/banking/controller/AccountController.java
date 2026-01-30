package com.fundme.banking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fundme.banking.model.Account;
import com.fundme.banking.service.AccountService;

@RestController
@RequestMapping("/")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    // POST /createAccount
    @PostMapping("/createAccount")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(service.createAccount(account));
    }

    // PUT /updateAccount/{accountNo}
    @PutMapping("/updateAccount/{accountNo}")
    public ResponseEntity<Account> updateAccount(
            @PathVariable Long accountNo,
            @RequestBody Account account) {
        return ResponseEntity.ok(service.updateAccount(accountNo, account));
    }

    // GET /viewPolicy/{accountNo}
    @GetMapping("/viewPolicy/{accountNo}")
    public ResponseEntity<Account> viewPolicy(@PathVariable Long accountNo) {
        return service.getAccount(accountNo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /deletePolicy/{accountNo}
    @DeleteMapping("/deletePolicy/{accountNo}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long accountNo) {
        service.deleteAccount(accountNo);
        return ResponseEntity.noContent().build();
    }
}
