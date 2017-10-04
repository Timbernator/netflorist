package com.netflorist.netflorist.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bank implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    private String bankType;
    private String accountNo;
    private String pin;
    private double balance;

    public Bank() {
    }

    public Bank(String bankType, String accountNo, String pin, double balance) {
        this.bankType = bankType;
        this.accountNo = accountNo;
        this.pin = pin;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
}
