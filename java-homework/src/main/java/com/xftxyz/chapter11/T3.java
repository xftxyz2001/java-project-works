package com.xftxyz.chapter11;

import com.xftxyz.chapter9.t7.Account;

public class T3 {

    public static void main(String[] args) {

        Account account = new Account(1122, 20000);
        account.setAnnualInterestRate(4.5);
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println(account);
        System.out.println("月利率为：" + account.getMonthlyInterestRate());
        System.out.println("月利息为：" + account.getMonthlyInterest());
        System.out.println("账户创建日期为：" + account.getDateCreated());

        CheckingAccount checkingAccount = new CheckingAccount(1122, 20000, 5000);
        checkingAccount.setAnnualInterestRate(4.5);
        checkingAccount.withdraw(2500);
        checkingAccount.deposit(3000);
        System.out.println(checkingAccount);
        System.out.println("月利率为：" + checkingAccount.getMonthlyInterestRate());
        System.out.println("月利息为：" + checkingAccount.getMonthlyInterest());
        System.out.println("账户创建日期为：" + checkingAccount.getDateCreated());

        SavingAccount savingAccount = new SavingAccount(1122, 20000);
        savingAccount.setAnnualInterestRate(4.5);
        savingAccount.withdraw(2500);
        savingAccount.deposit(3000);
        System.out.println(savingAccount);
        System.out.println("月利率为：" + savingAccount.getMonthlyInterestRate());
        System.out.println("月利息为：" + savingAccount.getMonthlyInterest());
        System.out.println("账户创建日期为：" + savingAccount.getDateCreated());
    }
}

class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount() {
        super();
    }

    public CheckingAccount(int id, double balance, double overdraftLimit) {
        super(id, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount < -overdraftLimit) {
            System.out.println("超过透支限额");
        } else {
            setBalance(getBalance() - amount);
        }
    }

    @Override
    public String toString() {
        return "CheckingAccount [overdraftLimit=" + overdraftLimit + ", toString()=" + super.toString() + "]";
    }

}

class SavingAccount extends Account {
    public SavingAccount() {
        super();
    }

    public SavingAccount(int id, double balance) {
        super(id, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount < 0) {
            System.out.println("余额不足");
        } else {
            setBalance(getBalance() - amount);
        }
    }

    @Override
    public String toString() {
        return "SavingAccount [toString()=" + super.toString() + "]";
    }

}