package com.xftxyz.bank.domain;

import java.math.BigDecimal;

import com.xftxyz.bank.service.BankException;

public abstract class Account {
    protected int id;
    protected int pin;
    protected BigDecimal balance;

    public Account(int id, int pin, BigDecimal balance) {
        this.id = id;
        this.pin = pin;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    // public void setPin(int pin) {
    // this.pin = pin;
    // }

    public BigDecimal getBalance() {
        return balance;
    }

    public abstract void deposit(BigDecimal a) throws BankException;

    public abstract void withdraw(BigDecimal a) throws BankException;

    public boolean checkPin(int pin) {
        return this.pin == pin;
    }
}
