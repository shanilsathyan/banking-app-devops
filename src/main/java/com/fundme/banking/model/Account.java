package com.fundme.banking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {

    @Id
    private Long accountNo;
    private String name;
    private String policyType;
    private Double balance;

    public Account() {}

    public Account(Long accountNo, String name, String policyType, Double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.policyType = policyType;
        this.balance = balance;
    }

    public Long getAccountNo() { return accountNo; }
    public void setAccountNo(Long accountNo) { this.accountNo = accountNo; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPolicyType() { return policyType; }
    public void setPolicyType(String policyType) { this.policyType = policyType; }

    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }
}
