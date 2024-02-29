package model.entities;

import model.exceptions.AccountException;

public class Account {
    
    private Integer number;
    private String holder;
    private Double balance;
    private double withdrawLimit;

    public Account() {} // Empty contructor...
    
    public Account(Integer number, String holder, Double balance, double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    // My methods
    public void deposit(Double amount) {
        balance += amount;
    }

    public void withdraw(Double amount) {
        
        if (balance < amount) {
            throw new AccountException("Not enough balance");
        }
        if (withdrawLimit < amount) {
            throw new AccountException("The amount exceeds withdraw limit");
        }

        balance -= amount;
    }

}