package com.xftxyz.bank.domain;

import java.math.BigDecimal;

import com.xftxyz.bank.service.BankException;
import com.xftxyz.bank.utils.XFConstant;

public class CheckingAccount extends Account {
    public static final BigDecimal LINES = new BigDecimal("-1000");

    public CheckingAccount(int id, int pin, BigDecimal balance) {
        super(id, pin, balance);
    }

    @Override
    public void deposit(BigDecimal a) {
        balance = balance.add(a);
    }

    @Override
    public void withdraw(BigDecimal a) throws BankException {
        if (balance.compareTo(a) < 0 && balance.subtract(a).compareTo(LINES) < 0) {
            // 余额不足，且信用额度不足
            throw new BankException("额度不足。" + balance);
        }
        balance = balance.subtract(a);
    }

    @Override
    public String toString() {
        return super.id + " " + super.pin + " " + XFConstant.CHECKING_ACCOUNT + " " + super.balance;
    }

}
