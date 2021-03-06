package com.xftxyz.bank.service;

import java.util.ArrayList;

import com.xftxyz.bank.domain.Account;
import com.xftxyz.bank.utils.MyFileReader;

/**
 * Title: Bank Account Manager
 * 
 * Description:
 * 
 * Design a program which acts as an ATM machine. The user can specify a PIN and
 * it shows them a menu of their account types (checking and savings). Allow the
 * user to deposit or withdraw money from a selected account type. Be sure to
 * check that they can’t withdraw more money than they have or if they deposit
 * more than $10k dollars, it lets the user know it will have to contact the
 * bank manager to clear the deposit and won’t let them then withdraw any of
 * that money.
 * 
 * Tips:
 * 
 * This is a classic example of class inheritance. Create an Account class which
 * will serve as the basis of both types of accounts. A checking and savings
 * account are both accounts right? They will inherit from the base Account
 * class. Keep basic functionality in the base class like deposit() and
 * withdraw() and then override them in the specific account types. A savings
 * account may also have things like interest applied or a penalty for
 * withdrawing any money. Take this into account when you override those
 * methods. The variable “balance” would also be a protected member of the base
 * class.
 * 
 * Added Difficulty:
 * 
 * Allow the checking account to go into negative and apply an overdraft fee of
 * $10. Don’t let the user go into overdraft protection more than $100. You
 * could also prevent the user from making multiple withdraws if they are
 * already overdrawn.
 */
public class AccountService {
    private ArrayList<Account> accounts = null;

    private AccountService() {
        accounts = MyFileReader.read();
    }

    public void addAccount(Account a) throws BankException {
        if (this.getAccount(a.getId()) != null) {
            throw new BankException("Account already exists: " + a.getId());
        }
        accounts.add(a);
    }

    public Account getAccount(int id) {
        int i = 0;
        Account ai = null;
        for (i = 0; i < accounts.size(); i++) {
            ai = accounts.get(i);
            if (ai.getId() == id) {
                return ai;
            }
        }
        return null;
    }

    public void saveAccounts() {
        MyFileReader.save(accounts);
    }

    private static AccountService instance = new AccountService();

    public static AccountService getInstance() {
        return instance;
    }

}
