package com.xftxyz.bank.domain;

import java.math.BigDecimal;

import com.xftxyz.bank.service.BankException;
import com.xftxyz.bank.utils.XFConstant;

public class SavingsAccount extends Account {

    public SavingsAccount(int id, int pin, BigDecimal balance) {
        super(id, pin, balance);
    }

    @Override
    public void deposit(BigDecimal a) {
        balance = balance.add(a);
    }

    @Override
    public void withdraw(BigDecimal a) throws BankException {
        if (balance.compareTo(a) < 0) {
            throw new BankException("余额不足。" + balance);
        }
        balance = balance.subtract(a);
    }

    @Override
    public String toString() {
        return super.id + " " + super.pin + " " + XFConstant.SAVINGS_ACCOUNT + " " + super.balance;
    }
}
