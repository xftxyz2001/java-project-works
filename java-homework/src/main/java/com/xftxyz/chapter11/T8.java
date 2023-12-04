package com.xftxyz.chapter11;

import java.util.ArrayList;
import java.util.Date;

public class T8 {

    public static void main(String[] args) {

        Account account = new Account("George", 1122, 1000);
        account.setAnnualInterestRate(1.5);
        account.deposit(30);
        account.deposit(40);
        account.deposit(50);
        account.withdraw(5);
        account.withdraw(4);
        account.withdraw(2);

        System.out.println("Name: " + account.getName());
        System.out.println("Annual interest rate: " + account.getAnnualInterestRate());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Transactions: ");
        for (Transaction transaction : account.getTransactions()) {
            System.out.println(transaction);
        }
    }
}

class Account {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated = new Date();

    private String name;

    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account() {

    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Account(String name, int id, double balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    public void withdraw(double amount) {
        transactions.add(new Transaction('W', amount, balance, "取款"));
        balance -= amount;
    }

    public void deposit(double amount) {
        transactions.add(new Transaction('D', amount, balance, "存款"));
        balance += amount;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", balance=" + balance + ", annualInterestRate=" + annualInterestRate
                + ", dateCreated=" + dateCreated + ", name=" + name + ", transactions=" + transactions + "]";
    }

}

class Transaction {
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;

    public Transaction() {

    }

    public Transaction(char type, double amount, double balance, String description) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
        date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction [date=" + date + ", type=" + type + ", amount=" + amount + ", balance=" + balance
                + ", description=" + description + "]";
    }

}