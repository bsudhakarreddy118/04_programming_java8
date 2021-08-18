package com.learn.banking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

enum AccountStatus {
    ACTIVE, DORMANT, CLOSED
}

public class SavingsAccount {

    private int accountNumber;
    private double balance;
    private Date openingDate;
    private AccountStatus status;

    public SavingsAccount() {
    }

    public SavingsAccount(int accountNumber, double balance, Date openingDate, AccountStatus status) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.openingDate = openingDate;
        this.status = status;
    }

    public boolean withdrawAmount(double amount) throws InsufficientBalanceException {
        if (!(status == AccountStatus.ACTIVE)) {
            return false;
        } else if (amount + 500 > balance) {
            throw new InsufficientBalanceException();
        } else {
            balance -= amount;
            return true;
        }
    }


    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public boolean depositAmount(double amount) {
        if (status == AccountStatus.ACTIVE) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }
}
